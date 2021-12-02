package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class P17SQLiteDatabase extends AppCompatActivity {
EditText edDbname,edDbpass,old_Name,new_Name,delName;
Button addDb,updateBtn,deleteBtn;
Spinner myDbSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p17_sqlite_database);
        edDbname=findViewById(R.id.editDbName);
        edDbpass=findViewById(R.id.editDbPass);
        addDb=findViewById(R.id.addDb);
        old_Name=findViewById(R.id.newName);
        new_Name=findViewById(R.id.oldName);
        updateBtn= findViewById(R.id.updateDb);
        deleteBtn=findViewById(R.id.deleteDb);
        delName=findViewById(R.id.deleteName);
        myDbSpinner=findViewById(R.id.myDbSpinner);
//       myDbSpinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        loadSpinnerData();
        addDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edDbname.getText().toString();
                String pass=edDbpass.getText().toString();

                if (name.trim().length()>0){
                    P17OpenHelperData p17OpenHelperData= new P17OpenHelperData(getApplicationContext());
                    p17OpenHelperData.insertData(name,pass);
                    Toast.makeText(getApplicationContext(), "Name : " + name + " Password : "+pass, Toast.LENGTH_SHORT).show();
                    // now setting the value of name and pass null
                    edDbname.setText("");
                    edDbpass.setText("");

                    // hiding the keyword
                    InputMethodManager inputManager=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(edDbname.getWindowToken(),0);
                    inputManager.hideSoftInputFromWindow(edDbpass.getWindowToken(),0);
                    loadSpinnerData();

                }

            }
        });
        // for updating the data
//        updateBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String oName,nName;
//                oName=old_Name.getText().toString();
//                nName=new_Name.getText().toString();
//                P17OpenHelperData up17data = new P17OpenHelperData(getApplicationContext());
//
//                if (oName.isEmpty() || nName.isEmpty()){
//                    old_Name.setError("Enter the OldName and newName ");
//                }
//                else {
////                    int updates= up17data.updateData(oName, nName);
//                    int updates= up17data.updateName(oName, nName);
//                   if(updates<=0){
//                       Toast.makeText(getApplicationContext(), "Not updated", Toast.LENGTH_SHORT).show();
//                       new_Name.setText("");
//                       old_Name.setText("");
//                   }
//                   else {
//                       Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
//                       new_Name.setText("");
//                       old_Name.setText("");
//
//                   }
//
//                }
//                loadSpinnerData();
//                update(v);
//            }
//        });

        myDbSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // for deleting selected name
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName=delName.getText().toString();
                if (getName.isEmpty()){
                    delName.setError("Enter the name");
                }
                else {
                    P17OpenHelperData po=new P17OpenHelperData(getApplicationContext());
                    Toast.makeText(getApplicationContext(), "deleted Successfully", Toast.LENGTH_SHORT).show();
                    po.deleteData(getName);
                    delName.setText("");
                    loadSpinnerData();


                }
            }
        });
    }

    // click listener on the add button to add entered values in the spinner
private  void loadSpinnerData(){
        P17OpenHelperData p17OpenHelperData= new P17OpenHelperData(getApplicationContext());
    List<String> inputData=p17OpenHelperData.getData();
    ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,inputData);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    myDbSpinner.setAdapter(adapter);
}


    public void update(View view){
//        String oldValue = old_Name.getText().toString();
//        String newValue = new_Name.getText().toString();

        P17OpenHelperData db = new   P17OpenHelperData(getApplicationContext());
        int id = db.updateName( old_Name.getText().toString(),new_Name.getText().toString());

        if(id <=0) {
            Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
            old_Name.setText("");
            new_Name.setText("");
        }
//        loadSpinnerData();

    }


    public void updateData1(View view) {
    }
}

