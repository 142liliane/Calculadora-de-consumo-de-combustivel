package br.ulbra.calculadoradeconsumodecombustvel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextVehicleName, editTextPlateNumber, editTextDistance, editTextFuelConsumption, editTextFuelPrice;
    private TextView textViewResult;
    private ImageButton buttonCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referência aos elementos da UI
        editTextVehicleName = findViewById(R.id.editNomeVeic);
        editTextPlateNumber = findViewById(R.id.editPlacaVeic);
        editTextDistance = findViewById(R.id.editDist);
        editTextFuelConsumption = findViewById(R.id.editCons);
        editTextFuelPrice = findViewById(R.id.editPreco);
        textViewResult = findViewById(R.id.txtResult);
        buttonCalculate = findViewById(R.id.btnCalc);


        // Configurar botão para calcular o consumo e o custo
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFuelAndCost();
            }
        });
    }

    private void calculateFuelAndCost() {
        // Pegar os valores de entrada
        String distanceStr = editTextDistance.getText().toString();
        String fuelConsumptionStr = editTextFuelConsumption.getText().toString();
        String fuelPriceStr = editTextFuelPrice.getText().toString();

        if (!distanceStr.isEmpty() && !fuelConsumptionStr.isEmpty() && !fuelPriceStr.isEmpty()) {
            // Converter para números
            double distance = Double.parseDouble(distanceStr);
            double fuelConsumption = Double.parseDouble(fuelConsumptionStr);
            double fuelPrice = Double.parseDouble(fuelPriceStr);

            // Calcular o consumo de combustível e o custo
            double fuelNeeded = distance / fuelConsumption;
            double tripCost = fuelNeeded * fuelPrice;

            // Exibir os resultados
            String result = String.format("Combustível necessário: %.2f L\nCusto da viagem: R$ %.2f", fuelNeeded, tripCost);
            textViewResult.setText(result);
        } else {
            textViewResult.setText("Por favor, preencha todos os campos.");
        }
    }
}