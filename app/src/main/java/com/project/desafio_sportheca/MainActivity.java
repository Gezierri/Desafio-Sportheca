package com.project.desafio_sportheca;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.project.desafio_sportheca.databinding.ActivityMainBinding;
import com.project.desafio_sportheca.models.ResponseClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        WindowInsetsControllerCompat windowInsetsController =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if (windowInsetsController == null) {
            return;
        }
// Hide the system bars.
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());

        RetrofitClient.getInstance()
                .getPlayer()
                .enqueue(
                        new Callback<ResponseClient>() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onResponse(Call<ResponseClient> call, retrofit2.Response<ResponseClient> response) {
                                ResponseClient client = response.body();
                                if (response.isSuccessful()) {
                                    client.getObjects().forEach(res -> {
                                        String icon = "\u00B0";
                                        Picasso.get().load(res.getPlayer().getImg()).into(binding.profileImage);
                                        binding.tvUsuario.setText(res.getPlayer().getName());
                                        binding.tvCountry.setText(res.getPlayer().getCountry());
                                        binding.tvAtacante.setText(res.getPlayer().getPos());
                                        binding.tvPercentual.setText(String.valueOf(String.format("%.3f", res.getPlayer().getPercentual())));

                                        binding.pbCopasVencidas.setProgress(getNumber(res.getPlayer().getBarras().getCopasVencidas().getPla()), true);
                                        binding.pbCopasVencidas.setMax(getNumber(res.getPlayer().getBarras().getCopasVencidas().getMax()));
                                        binding.tvCopaVencidasPla.setText(res.getPlayer().getBarras().getCopasVencidas().getPla());
                                        binding.tvCopaVencidasPos.setText(res.getPlayer().getBarras().getCopasVencidas().getPos().concat(icon));

                                        binding.pbCopasDisputadas.setProgress(getNumber(res.getPlayer().getBarras().getCopasVencidas().getMax()), true);
                                        binding.pbCopasDisputadas.setMax(getNumber(res.getPlayer().getBarras().getCopasDisputadas().getMax()));
                                        binding.tvCopasDisputadasPla.setText(res.getPlayer().getBarras().getCopasDisputadas().getPla());
                                        binding.tvCopasDisputadasPos.setText(res.getPlayer().getBarras().getCopasDisputadas().getPos().concat(icon));
                                    });
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseClient> call, Throwable t) {
                                message(t.getMessage());
                            }
                        }
                );
    }

    private void message(String msg) {
        Toast.makeText(this, "Erro ao gerar dados" + msg, Toast.LENGTH_LONG).show();
    }

    private int getNumber(String pla) {
        pla = String.valueOf(pla.charAt(0));
        int valor = Integer.parseInt(pla);
        return valor;
    }
}