package co.edu.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import co.edu.taller1.entidades.RegistroProducto2;
import co.edu.taller1.entidades.RegistroCliente2;

public class Producto2 extends AppCompatActivity {
    Spinner spFacturaProducto1;
    Spinner spFacturaProducto2;
    Spinner spFacturaProducto3;
    Spinner spFacturaProducto4;
    Spinner spFacturaProducto5;
    Spinner spFacturaProducto6;
    Button btnFactura;
    Integer totalP;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra2);
        begin();
        productosInfo();

        this.btnFactura.setOnClickListener(this::irfactura);
    }

    private void irfactura(View view) {
        Bundle dataCliente = getIntent().getExtras();
        RegistroCliente2 cliente = new RegistroCliente2();
        cliente = (RegistroCliente2) dataCliente.get("Datos");
        Intent irafactura = new Intent(getApplicationContext(), Factura2.class);
        RegistroProducto2 info1 = (RegistroProducto2) spFacturaProducto1.getSelectedItem();
        String producto1 = info1.getNombreProducto();
        RegistroProducto2 info2 = (RegistroProducto2) spFacturaProducto2.getSelectedItem();
        String producto2 = info2.getNombreProducto();
        RegistroProducto2 info3 = (RegistroProducto2) spFacturaProducto3.getSelectedItem();
        String producto3 = info3.getNombreProducto();
        RegistroProducto2 info4 = (RegistroProducto2) spFacturaProducto4.getSelectedItem();
        String producto4 = info4.getNombreProducto();
        RegistroProducto2 info5 = (RegistroProducto2) spFacturaProducto5.getSelectedItem();
        String producto5 = info5.getNombreProducto();
        RegistroProducto2 info6 = (RegistroProducto2) spFacturaProducto6.getSelectedItem();
        String producto6 = info6.getNombreProducto();
        String precio1 = info1.getPrecio().toString();
        String precio2 = info2.getPrecio().toString();
        String precio3 = info3.getPrecio().toString();
        String precio4 = info4.getPrecio().toString();
        String precio5 = info5.getPrecio().toString();
        String precio6 = info6.getPrecio().toString();
        Integer valor1 = info1.getPrecio();
        Integer valor2 = info2.getPrecio();
        Integer valor3 = info3.getPrecio();
        Integer valor4 = info4.getPrecio();
        Integer valor5 = info5.getPrecio();
        Integer valor6 = info6.getPrecio();
        totalP = valor1 + valor2 + valor3 + valor4 + valor5+ valor6;
        String totalpr = String.valueOf(totalP);

        irafactura.putExtra("Producto1", producto1);
        irafactura.putExtra("Producto2", producto2);
        irafactura.putExtra("Producto3", producto3);
        irafactura.putExtra("Producto4", producto4);
        irafactura.putExtra("Producto5", producto5);
        irafactura.putExtra("Producto6", producto6);
        irafactura.putExtra("Compra1", precio1);
        irafactura.putExtra("Compra2", precio2);
        irafactura.putExtra("Compra3", precio3);
        irafactura.putExtra("Compra4", precio4);
        irafactura.putExtra("Compra5", precio5);
        irafactura.putExtra("Compra6", precio6);
        irafactura.putExtra("datosCliente", cliente);
        irafactura.putExtra("Total", totalpr);
        startActivity(irafactura);
    }
    private void begin(){
        this.spFacturaProducto1 = findViewById(R.id.spFacturaProducto1);
        this.spFacturaProducto2 = findViewById(R.id.spFacturaProducto2);
        this.spFacturaProducto3 = findViewById(R.id.spFacturaProducto3);
        this.spFacturaProducto4 = findViewById(R.id.spFacturaProducto4);
        this.spFacturaProducto5 = findViewById(R.id.spFacturaProducto5);
        this.spFacturaProducto6 = findViewById(R.id.spFacturaProducto6);
        this.btnFactura = findViewById(R.id.btnFactura);
    }
    private void productosInfo(){
        ArrayList<RegistroProducto2> producto = new ArrayList<>();
        producto.add(new RegistroProducto2(1, "Helado", 2800));
        producto.add(new RegistroProducto2(2, "Gaseosa", 2500));
        producto.add(new RegistroProducto2(3, "Paquete de papas", 3300));
        producto.add(new RegistroProducto2(4, "Gomitas", 1600));
        producto.add(new RegistroProducto2(5, "Chocorramo", 2200));
        producto.add(new RegistroProducto2(6, "Pringles", 6000));
        ArrayAdapter<RegistroProducto2> adaptador = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, producto);
        spFacturaProducto1.setAdapter(adaptador);
        spFacturaProducto2.setAdapter(adaptador);
        spFacturaProducto3.setAdapter(adaptador);
        spFacturaProducto4.setAdapter(adaptador);
        spFacturaProducto5.setAdapter(adaptador);
        spFacturaProducto6.setAdapter(adaptador);
    }
}
