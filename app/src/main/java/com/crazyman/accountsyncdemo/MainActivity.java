package com.crazyman.accountsyncdemo;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //添加账号
        Account account = new Account("account_test", "com.crazyman.accountsyncdemo.type");
        AccountManager accountManager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
        accountManager.addAccountExplicitly(account, null, null);

        //测试同步
        ContentResolver.setIsSyncable(account,"com.crazyman.accountsyncdemo.provider",1);
        ContentResolver.setSyncAutomatically(account,"com.crazyman.accountsyncdemo.provider",true);
        ContentResolver.addPeriodicSync(account,"com.crazyman.accountsyncdemo.provider",Bundle.EMPTY,10);
    }
}
