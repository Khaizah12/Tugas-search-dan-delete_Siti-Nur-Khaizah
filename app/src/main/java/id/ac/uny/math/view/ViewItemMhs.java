package id.ac.uny.math.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Delete;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

import id.ac.uny.math.R;
import id.ac.uny.math.data.MhsEntity;

public class ViewItemMhs extends RelativeLayout {
    Context context;
    TextView txtHp;
    TextView txtNama;
    TextView txtAlamat;
    Button btnEdit, btnDelete;
    MhsEntity mhsEntity;

    public ViewItemMhs(Context context) {
        super(context);
        inflate(context);
    }

    public ViewItemMhs(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context);
    }

    public ViewItemMhs(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context);
    }

    public MhsEntity getMhsEntity() {
        return mhsEntity;
    }

    public void setMhsEntity(MhsEntity mhsEntity) {
        this.mhsEntity = mhsEntity;
        txtNama.setText(mhsEntity.getNama());
        txtAlamat.setText(mhsEntity.getAlamat());
        txtHp.setText(mhsEntity.getHp());
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    void inflate(Context context) {
        this.context = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.layout_item_mhs, this);
        txtHp = findViewById(R.id.txtHP);
        txtNama = findViewById(R.id.txtNama);
        txtAlamat = findViewById(R.id.txtAlamat);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("mhsEntity", mhsEntity.toParcel());
                ((Activity) context).startActivityForResult(intent, MainActivity.CRUD_REQ);
            }
        });
        btnDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DeleteActivity.class);
                intent.putExtra("mhsEntity", mhsEntity.toParcel());
                ((Activity) context).startActivityForResult(intent, MainActivity.CRUD_REQ);
            }
        });
    }
}
