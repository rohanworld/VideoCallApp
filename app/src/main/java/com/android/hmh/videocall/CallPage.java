package com.android.hmh.videocall;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zegocloud.uikit.prebuilt.call.invite.widget.ZegoSendCallInvitationButton;
import com.zegocloud.uikit.service.defines.ZegoUIKitUser;

import java.util.Collections;

public class CallPage extends AppCompatActivity {
    TextView showMyName;
    EditText whomToCall;
    ZegoSendCallInvitationButton voiceCall, videoCall;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_page);
        String myName = getIntent().getStringExtra("myName");
        Toast.makeText(this, "Welcome "+myName, Toast.LENGTH_SHORT).show();
        showMyName = findViewById(R.id.showMyName);
        voiceCall = findViewById(R.id.voiceCall);
        videoCall = findViewById(R.id.videoCall);
        whomToCall = findViewById(R.id.whomToCall);

        showMyName.setText("Hey, "+myName);

        whomToCall.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String targetUsedId = whomToCall.getText().toString().trim();
                setVoiceCall(targetUsedId);
                setVideoCall(targetUsedId);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    void setVoiceCall(String targetUserID){
        String targetUserName = targetUserID; // The username of the user you want to call.
        voiceCall.setIsVideoCall(false);
        voiceCall.setResourceID("zego_uikit_call");
        voiceCall.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserID,targetUserName)));
    }

    void setVideoCall(String targetUserID){
        String targetUserName = targetUserID; // The username of the user you want to call.
        videoCall.setIsVideoCall(true);
        videoCall.setResourceID("zego_uikit_call");
        videoCall.setInvitees(Collections.singletonList(new ZegoUIKitUser(targetUserID,targetUserName)));
    }

}