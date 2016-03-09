package lab1.cmpe235.sjsu.smartstreet.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import lab1.cmpe235.sjsu.smartstreet.utils.CaptureActivityAnyOrientation;
import lab1.cmpe235.sjsu.smartstreet.R;

public class AboutActivity extends Activity {
    AlertDialog.Builder builder =  null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

    }

   public void scanQR(View v) {
       IntentIntegrator integrator = new IntentIntegrator(this);
       integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
       integrator.setCaptureActivity(CaptureActivityAnyOrientation.class);
       integrator.setOrientationLocked(false);
       integrator.setPrompt("Scan Smart Tree barcode");
       integrator.setCameraId(0);
       integrator.setBeepEnabled(false);
       integrator.setBarcodeImageEnabled(true);
       integrator.initiateScan();
   }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanResult != null) {
            String re = scanResult.getContents();

            if (re != null) {
                showDialog("Barcode scanned successful ", getMessageInfo(scanResult), scanResult.getContents());
            }

        } else {
            Log.i("Result", "null value");
        }
    }

    private String getMessageInfo(IntentResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t").append("Format: ").append(result.getFormatName()).append("\n");
        sb.append("\t\t").append("EC level: ").append(result.getErrorCorrectionLevel()).append("\n");
        sb.append("\t\t").append("Barcode Path: ").append(result.getBarcodeImagePath());
        return sb.toString();

    }
    private void showDialog(String title, String message, String hyperlink) {
        LayoutInflater inflater = this.getLayoutInflater();
        View v = inflater.inflate(R.layout.message, null);
        TextView barcodeTv = (TextView) v.findViewById(R.id.barcode_info);
        barcodeTv.setText(message);
        TextView tv = (TextView) v.findViewById(R.id.url);
        SpannableString msg =
                new SpannableString(hyperlink);
        Linkify.addLinks(msg, Linkify.WEB_URLS);
        tv.setText(msg);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setView(v);
        builder.setPositiveButton("OK", null);
        builder.show();
    }

}