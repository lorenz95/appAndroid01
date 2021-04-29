package com.example.examplecontacts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.example.examplecontacts.MainActivity.TAG_insert;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static int numConctact = 0;

    private Button btnInsert;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertFragment newInstance(String param1, String param2) {
        InsertFragment fragment = new InsertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.i("info", "Crato in");

        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        EditText edtName = view.findViewById(R.id.textName);
        EditText edtCognome = view.findViewById(R.id.textCognome);
        EditText edtTelefono = view.findViewById(R.id.textTelefono);

        btnInsert = view.findViewById(R.id.btnCntIns);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contatto contatto = new Contatto(numConctact, edtName.getText().toString(),
                        edtCognome.getText().toString(), edtTelefono.getText().toString());

                File path = getActivity().getApplicationContext().getFilesDir();
                Log.d(TAG_insert, "path " + path);

                FileOutputStream fileOutputStream;
                ObjectOutputStream objectOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(path+"/contatto.ser");
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);

                    LeggiFile.setPathFile(path+"/contatto.ser");
                    List<Contatto> contattoList = LeggiFile.getListContatti();
                    contattoList.add(contatto);

                    objectOutputStream.writeObject(contattoList);
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }
}