package vn.iotstar.btlistview28_02.GridView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import vn.iotstar.btlistview28_02.MainActivity;
import vn.iotstar.btlistview28_02.R;

public class GridViewActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<String> arrayList;
    EditText edt_Input;
    Button btn_add, btn_update;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.gridView);
        edt_Input = findViewById(R.id.editTextInput);
        btn_add = findViewById(R.id.btnSubmit);
        btn_update = findViewById(R.id.btnUpdate);

        arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kolin");
        arrayList.add("Dart");

        ArrayAdapter adapter = new ArrayAdapter(GridViewActivity.this,  R.layout.grid_item, R.id.textViewItem, arrayList);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this," " + i + " " + arrayList.get(i),
                        Toast.LENGTH_SHORT).show();
                edt_Input.setText(arrayList.get(i));
                vitri = i;
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridViewActivity.this, "Bạn đang nhấn giữ "+ i + "-" + arrayList.get(i) ,
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_Input.getText().toString();
                arrayList.add(name);
                adapter.notifyDataSetChanged();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.set(vitri, edt_Input.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}