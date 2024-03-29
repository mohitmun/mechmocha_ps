//package com.mechmocha_chorsipahi.ui;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//
//
//import android.os.Bundle;
//
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.OrientationHelper;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//
//import android.view.View;
//import android.widget.*;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
//import io.agora.AgoraAPI;
//import io.agora.AgoraAPIOnlySignal;
//import io.agora.IAgoraAPI;
//import io.agora.adapter.MessageAdapter;
//import io.agora.model.MessageBean;
//import io.agora.model.MessageListBean;
//import io.agora.sginatutorial.AGApplication;
//import io.agora.sginatutorial.R;
//import io.agora.utils.Constant;
//import io.agora.utils.ToastUtils;
//
///**
// * Created by beryl on 2017/11/6.
// */
//
//public class MessageActivity extends Activity {
//    private final String TAG = MessageActivity.class.getSimpleName();
//
//    private AgoraAPIOnlySignal agoraAPI;
//    private TextView textViewTitle;
//    private EditText editText;
//    private RecyclerView recyclerView;
//    private List<MessageBean> messageBeanList;
//    private MessageAdapter adapter;
//
//    private String channelName = "";
//    private String selfName = "";
//    private boolean stateSingleMode = true; // single mode or channel mode
//    private int channelUserCount;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_message);
//
//        InitUI();
//        setupData();
//    }
//
//
//    private void InitUI() {
//        textViewTitle = (TextView) findViewById(R.id.message_title);
//        editText = (EditText) findViewById(R.id.message_edittiext);
//        recyclerView = (RecyclerView) findViewById(R.id.message_list);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        layoutManager.setOrientation(OrientationHelper.VERTICAL);
//    }
//
//
//    private void setupData() {
//
//        Intent intent = getIntent();
//        channelName = intent.getStringExtra("name");
//        selfName = intent.getStringExtra("selfname");
//        stateSingleMode = intent.getBooleanExtra("mode", true);
//        channelUserCount = intent.getIntExtra("usercount", 0);
//        textViewTitle.setText(channelName + "(" + channelUserCount + ")");
//
//        if (stateSingleMode) {
//            MessageListBean messageListBean = Constant.getExistMesageListBean(channelName);
//            if (messageListBean == null) {
//                messageBeanList = new ArrayList<>();
//            } else {
//                messageBeanList = messageListBean.getMessageBeanList();
//            }
//        } else {
//            messageBeanList = new ArrayList<>();
//        }
//        adapter = new MessageAdapter(this, messageBeanList);
//        recyclerView.setAdapter(adapter);
//
//        agoraAPI = AGApplication.the().getmAgoraAPI();
//        if (stateSingleMode) {
//            agoraAPI.queryUserStatus(channelName);
//        }
//
//    }
//
//
//    /**
//     * siginal callback
//     */
//    private void addCallback() {
//        if (agoraAPI == null) {
//            return;
//        }
//
//
//    }
//
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        addCallback();
//
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        if (stateSingleMode) {
//            Constant.addMessageListBeanList(new MessageListBean(channelName, messageBeanList));
//        } else {
//            if (agoraAPI != null) {
//                agoraAPI.channelLeave(channelName);
//
//            }
//        }
//
//    }
//
//    public void onClickSend(View v) {
//        String msg = editText.getText().toString();
//        if (msg != null && !msg.equals("")) {
//            MessageBean messageBean = new MessageBean(selfName, msg, true);
//            messageBeanList.add(messageBean);
//            adapter.notifyItemRangeChanged(messageBeanList.size(), 1);
//            recyclerView.scrollToPosition(messageBeanList.size() - 1);
//
//            if (stateSingleMode) {
//                agoraAPI.messageInstantSend(channelName, 0, msg, "");
//            } else {
//                agoraAPI.messageChannelSend(channelName, msg, "");
//            }
//
//        }
//        editText.setText("");
//
//    }
//
//
//    public void onClickFinish(View v) {
//        finish();
//    }
//
//    //get exist account message color
//    private int getMessageColor(String account) {
//        for (int i = 0; i < messageBeanList.size(); i++) {
//            if (account.equals(messageBeanList.get(i).getAccount())) {
//                return messageBeanList.get(i).getBackground();
//            }
//        }
//        return Constant.COLOR_ARRAY[Constant.RANDOM.nextInt(Constant.COLOR_ARRAY.length)];
//    }
//
//
//}
