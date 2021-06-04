package id.ac.uny.math.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import id.ac.uny.math.R;
import id.ac.uny.math.data.MhsEntity;
import id.ac.uny.math.data.MhsParcel;

import static id.ac.uny.math.MathApp.mathDatabase;

public class DeleteActivity extends AppCompatActivity {
        MhsParcel mhsParcel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete3);
        mhsParcel = getIntent().getParcelableExtra("mhsEntity");
        MhsEntity mhsEntity=mhsParcel.toEntity();

        startActivity(new Intent(DeleteActivity.this,MainActivity.class));
        Context context = null;
        Intent intent = new Intent(context, DeleteActivity.class);
        intent.putExtra("mhsEntity", mhsEntity.toParcel());
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}