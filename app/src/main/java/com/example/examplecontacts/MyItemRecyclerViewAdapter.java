package com.example.examplecontacts;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.examplecontacts.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {
    private static String TAG = "MyItemRecyclerViewAdapter";

    private final List<Contatto> mValues;

    public MyItemRecyclerViewAdapter(List<Contatto> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contatto_layout, parent, false);
        MyItemRecyclerViewAdapter.ViewHolder sh = new MyItemRecyclerViewAdapter.ViewHolder(view);
        return sh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        MyItemRecyclerViewAdapter.ViewHolder savh = (MyItemRecyclerViewAdapter.ViewHolder) holder;

        Contatto contatto = mValues.get(position);

        TextView txtId = savh.getTxtId();
        txtId.setText(contatto.getIdAsString());

        TextView txtNome = savh.getTxtName();
        txtNome.setText( "Nome ".concat(contatto.getNome()));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private TextView txtId;
        private TextView txtName;
        private TextView txtCognome;
        private TextView txtTelefono;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtId = itemView.findViewById(R.id.textId);
            txtName = itemView.findViewById(R.id.nameId);
            txtCognome = itemView.findViewById(R.id.cognomeId);
            txtTelefono = itemView.findViewById(R.id.telefonoId);
        }

        public TextView getTxtId() {
            return txtId;
        }

        public TextView getTxtName() {
            return txtName;
        }

        public TextView getTxtCognome() {
            return txtCognome;
        }

        public TextView getTxtTelefono() {
            return txtTelefono;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}