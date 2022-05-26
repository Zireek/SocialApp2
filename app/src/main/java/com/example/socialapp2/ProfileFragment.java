package com.example.socialapp2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ProfileFragment extends Fragment {

    ImageView photoImageView;
    TextView displayNameTextView, emailTextView;

    public ProfileFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        photoImageView = view.findViewById(R.id.authorPhotoImageView);
        displayNameTextView = view.findViewById(R.id.displayNameTextView);
        emailTextView = view.findViewById(R.id.emailTextView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null){

            if(user.getPhotoUrl() == null) {
                photoImageView.setImageResource(R.drawable.usuariodesconocido);
                displayNameTextView.setText("Usuario sin información");
                emailTextView.setText(user.getEmail());
            }
            else
            {
                // Google
                Glide.with(requireView()).load(user.getPhotoUrl()).into(photoImageView);
                displayNameTextView.setText(user.getDisplayName());
                emailTextView.setText(user.getEmail());
            }
        }
    }
}