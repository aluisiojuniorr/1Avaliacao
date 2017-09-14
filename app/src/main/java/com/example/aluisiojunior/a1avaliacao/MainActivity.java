package com.example.aluisiojunior.a1avaliacao;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private boolean r1, reservado;
    private String c1, c2, c3, c4;
    private int Ano, Mes, Dia, Hora, Minuto, Segundo;
    private EditText edt_dataID, edt_horaID;
    private ImageButton btn_gravar;

    public void onRadio(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked) {
                    r1 = true;
                } else {
                    r1 = false;
                }
                break;

        }
    }

    public void reservado(View view) {
        boolean checked = ((ToggleButton) view).isChecked();

        switch (view.getId()) {
            case R.id.toggleButton2:
                if (checked) {
                    reservado = true;
                } else {
                    reservado = false;
                }
                break;
        }
    }

    public void configuracao(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkBox1:
                if (checked)
                    c1 = "Android Studio + Android SDK";
                break;

            case R.id.checkBox2:
                if (checked)
                    c2 = "java SDK";
                break;

            case R.id.checkBox3:
                if (checked)
                    c3 = "Sistema Operacional Linux";
                break;

            case R.id.checkBox4:
                if (checked)
                    c4 = "Sistema Operacional Windowns";
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        final Contexto contexto = (Contexto) MainActivity.this.getApplicationContext();

        EditText edt_NomeID = (EditText) findViewById(R.id.edt_NomeID);
        EditText edt_ID = (EditText) findViewById(R.id.edt_ID);
        EditText edt_EmailID = (EditText) findViewById(R.id.edt_EmailID);
        EditText edt_dataID = (EditText) findViewById(R.id.edt_dataID);
        EditText edt_horaID = (EditText) findViewById(R.id.edt_horaID);
        btn_gravar = (ImageButton) findViewById(R.id.btn_gravar);

        contexto.setNome(edt_NomeID.getText().toString());
        contexto.setID(edt_ID.getText().toString());
        contexto.setEmail(edt_EmailID.getText().toString());
        contexto.setData(edt_dataID.getText().toString());
        contexto.setHora(edt_horaID.getText().toString());
        contexto.setCheck1(c1);
        contexto.setCheck1(c2);
        contexto.setCheck1(c3);
        contexto.setCheck1(c4);
        contexto.setReserva(reservado);
        contexto.setDataShow(r1);

        InicializaListeners();

        btn_gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intenteImplicido();
            }
        });

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String spinner = adapter.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void InicializaListeners() {
        edt_dataID = (EditText) findViewById(R.id.edt_dataID);
        edt_horaID = (EditText) findViewById(R.id.edt_horaID);

        //AtualizarDataCorrente3D();
        //edt_dataID.setText(edt_dataID.getText());
        //edt_horaID.setText(edt_horaID.getText());
    }

    public class DatePickerFragment1 extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendario = Calendar.getInstance();
            Ano = calendario.get(Calendar.YEAR);
            Mes = calendario.get(Calendar.MONTH);
            Dia = calendario.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, Ano, Mes, Dia);
        }

        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            Ano = year;
            Mes = month;
            Dia = day;
            AtualizarData1();
            MensagemData1();
        }

        @Override
        public int show(FragmentTransaction transaction, String tag) {
            return super.show(transaction, tag);
        }
    }

    private void AtualizarData1() {
        edt_dataID.setText(new StringBuilder().append(Dia).append("/").append(Mes + 1).append("/").append(Ano).append(" "));
    }

    public void MostrarData1(View v) {
        DialogFragment ClasseData = new DatePickerFragment1();
        ClasseData.show(getFragmentManager(), "datepicker");
    }

    private void MensagemData1() {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toastID));
        TextView text = (TextView) layout.findViewById(R.id.textView);
        text.setText("Data: " + edt_dataID.getText());

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

        //Toast.makeText(this, new StringBuilder().append("Data: ").append(edt_dataID.getText()), Toast.LENGTH_SHORT).show();
    }

    private void AtualizarDataCorrente3D() {
        Date dt3 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt3);
        cal.add(Calendar.DATE, -3);
        dt3 = cal.getTime();

        String dataFormat = "";
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dt3;
            try {
                if ("".equals(String.valueOf(edt_dataID.getText()))) {
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    edt_dataID.setText(df.format(date));
                }
                date = originalFormat.parse(String.valueOf(edt_dataID.getText()));
                dataFormat = targetFormat.format(date);
            } catch (ParseException ex) {
            }
        } catch (Exception e) {
            e = e;
        }
    }

    private void AtualizarHoraCorrente() {
        Date dt3 = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt3);
        cal.add(Calendar.DATE, -3);
        dt3 = cal.getTime();

        String dataFormat = "";
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dt3;
            try {
                if ("".equals(String.valueOf(edt_dataID.getText()))) {
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    edt_dataID.setText(df.format(date));
                }
                date = originalFormat.parse(String.valueOf(edt_dataID.getText()));
                dataFormat = targetFormat.format(date);
            } catch (ParseException ex) {
            }
        } catch (Exception e) {
            e = e;
        }
    }

    public void MostrarHora(View v) {
        DialogFragment ClasseData = new TimePickerFragment();
        ClasseData.show(getFragmentManager(), "timePicker");
    }

    private void AtualizarHora() {
        edt_horaID.setText(new StringBuilder().append(Hora).append(":").append(Minuto).append(":").append(Segundo).append(""));
    }

    private void MensagemHora() {
        Toast.makeText(this, new StringBuilder().append("Hora: ").append(edt_horaID.getText()), Toast.LENGTH_SHORT).show();
    }

    public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendario = Calendar.getInstance();
            Hora = calendario.get(Calendar.HOUR_OF_DAY);
            Minuto = calendario.get(Calendar.MINUTE);
            Segundo = calendario.get(Calendar.SECOND);
            return new TimePickerDialog(getActivity(), this, Hora, Minuto, true);
        }

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Hora = hourOfDay;
            Minuto = minute;

            AtualizarHora();
            MensagemHora();
        }

        @Override
        public int show(FragmentTransaction transaction, String tag) {
            return super.show(transaction, tag);
        }

    }


    private void intenteImplicido() {
        Contexto contexto = (Contexto) this.getApplicationContext();

        Intent intent = getIntent();
        EditText edt_NomeID = (EditText) findViewById(R.id.edt_NomeID);
        EditText edt_ID = (EditText) findViewById(R.id.edt_ID);
        EditText edt_EmailID = (EditText) findViewById(R.id.edt_EmailID);
        EditText edt_dataID = (EditText) findViewById(R.id.edt_dataID);
        EditText edt_horaID = (EditText) findViewById(R.id.edt_horaID);
        btn_gravar = (ImageButton) findViewById(R.id.btn_gravar);

        contexto.setNome(edt_NomeID.getText().toString());
        contexto.setID(edt_ID.getText().toString());
        contexto.setEmail(edt_EmailID.getText().toString());
        contexto.setData(edt_dataID.getText().toString());
        contexto.setHora(edt_horaID.getText().toString());
        contexto.setCheck1(c1);
        contexto.setCheck1(c2);
        contexto.setCheck1(c3);
        contexto.setCheck1(c4);
        contexto.setReserva(reservado);
        contexto.setDataShow(r1);

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{contexto.getEmail()});
        email.putExtra(Intent.EXTRA_SUBJECT, "Cadastro Professor");
        email.putExtra(Intent.EXTRA_TEXT, contexto.getNome());
        email.setType("plain/text");
        startActivity(Intent.createChooser(email, "Sending mail..."));
    }
}

