package com.example.alvinafandi.eatiwul;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class DataActivity extends AppCompatActivity {

    private static final int CHOOSE_IMAGE = 101 ;
    private ImageView imageView;
    private EditText editText;
    private Button buttonSave;
    private ProgressBar progressBar;
    private Uri uriProfileImage;
    private String profileImageUrl;
    private FirebaseAuth firebaseAuth;



    private void uploadImageToFirebaseStorage() {
        final StorageReference profileImageRef = FirebaseStorage.getInstance().getReference("profilepics/"+System.currentTimeMillis()+".jpg");

        if(uriProfileImage != null){
            progressBar.setVisibility(View.VISIBLE);
            profileImageRef.putFile(uriProfileImage)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressBar.setVisibility(View.GONE);
                            profileImageUrl = taskSnapshot.getDownloadUrl().toString();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(DataActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        firebaseAuth = FirebaseAuth.getInstance();
        imageView = (ImageView) findViewById(R.id.imageViewData);
        editText = (EditText) findViewById(R.id.editTextDisplayName);
        buttonSave = (Button) findViewById(R.id.buttonSave);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        loadUserInformation();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showImageChoser();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInformation();
            }
        });




    }

    private void loadUserInformation() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null) {
            if (user.getPhotoUrl() != null) {
                Glide.with(this)
                        .load(user.getPhotoUrl().toString())
                        .into(imageView);
            }
            if (user.getDisplayName() != null) {
                editText.setText(user.getDisplayName());
            }
        }
    }

    private void saveUserInformation() {
        String name = editText.getText().toString();
        if(name.isEmpty()){
            editText.setError("Name required!");
            editText.requestFocus();
            return;
        }
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null && profileImageUrl!=null){
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(name)
                    .setPhotoUri(Uri.parse(profileImageUrl))
                    .build();
            user.updateProfile(profile)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Profile Updated",Toast.LENGTH_LONG).show();
                                finish();
                                Intent intent = new Intent(DataActivity.this, CharacterActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                        }
                    });
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data!=null && data.getData()!=null){
            uriProfileImage = data.getData();
            try{

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uriProfileImage);
                imageView.setImageBitmap(bitmap);
                uploadImageToFirebaseStorage();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private void showImageChoser(){
        Intent intent = new Intent(
                Intent.ACTION_PICK
        );
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent,"Select Profile Image"),  CHOOSE_IMAGE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
    }
}
