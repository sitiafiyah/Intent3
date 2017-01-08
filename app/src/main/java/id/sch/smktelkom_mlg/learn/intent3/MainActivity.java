package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageViewPhone)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialPhoneNumber("0341712500");
                    }
                });

        findViewById(R.id.imageViewSMS)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        composeSmsMessage("Pesan dari SMK telkom Malang");
                    }
                });

        findViewById(R.id.imageViewBrowser)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openWebPage("http://www.smktelkom-mlg.sch.id/");
                    }
                });

        findViewById(R.id.imageViewCamera)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        capturePhoto();
                    }
                });

    }

    private void capturePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    private void composeSmsMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }
}
