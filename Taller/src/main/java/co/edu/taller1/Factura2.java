package co.edu.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import co.edu.taller1.entidades.RegistroCliente2;
public class Factura2 extends AppCompatActivity {
    private TextView tvFacturaCliente;
    private TextView tvFacturaCompra1;
    private TextView tvFacturaCompra2;
    private TextView tvFacturaCompra3;
    private TextView tvFacturaCompra4;
    private TextView tvFacturaCompra5;
    private TextView tvFacturaCompra6;
    private TextView tvFacturaPrecio1;
    private TextView tvFacturaPrecio2;
    private TextView tvFacturaPrecio3;
    private TextView tvFacturaPrecio4;
    private TextView tvFacturaPrecio5;
    private TextView tvFacturaPrecio6;
    private TextView tvFacturaTotalP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura2);
        begin();
        mostrarProductos();
    }
    private void begin(){
        this.tvFacturaCliente = findViewById(R.id.tvFacturaCliente);
        this.tvFacturaCompra1 = findViewById(R.id.tvFacturaCompra1);
        this.tvFacturaCompra2 = findViewById(R.id.tvFacturaCompra2);
        this.tvFacturaCompra3 = findViewById(R.id.tvFacturaCompra3);
        this.tvFacturaCompra4 = findViewById(R.id.tvFacturaCompra4);
        this.tvFacturaCompra5 = findViewById(R.id.tvFacturaCompra5);
        this.tvFacturaCompra6 = findViewById(R.id.tvFacturaCompra6);
        this.tvFacturaPrecio1 = findViewById(R.id.tvFacturaPrecio1);
        this.tvFacturaPrecio2 = findViewById(R.id.tvFacturaPrecio2);
        this.tvFacturaPrecio3 = findViewById(R.id.tvFacturaPrecio3);
        this.tvFacturaPrecio4 = findViewById(R.id.tvFacturaPrecio4);
        this.tvFacturaPrecio5 = findViewById(R.id.tvFacturaPrecio5);
        this.tvFacturaPrecio6 = findViewById(R.id.tvFacturaPrecio6);
        this.tvFacturaTotalP = findViewById(R.id.tvFacturaTotalP);

    }
    private void mostrarProductos(){
        Bundle dataCliente = getIntent().getExtras();
        RegistroCliente2 cliente = new RegistroCliente2();
        cliente = (RegistroCliente2) dataCliente.get("datosCliente");
        Intent irafactura = getIntent();
        String datospr1 = irafactura.getStringExtra("Producto1");
        String datospr2 = irafactura.getStringExtra("Producto2");
        String datospr3 = irafactura.getStringExtra("Producto3");
        String datospr4 = irafactura.getStringExtra("Producto4");
        String datospr5 = irafactura.getStringExtra("Producto5");
        String datospr6 = irafactura.getStringExtra("Producto6");
        String datospre1 = irafactura.getStringExtra("Compra1");
        String datospre2 = irafactura.getStringExtra("Compra2");
        String datospre3 = irafactura.getStringExtra("Compra3");
        String datospre4 = irafactura.getStringExtra("Compra4");
        String datospre5 = irafactura.getStringExtra("Compra5");
        String datospre6 = irafactura.getStringExtra("Compra6");
        String Totalp = irafactura.getStringExtra("Total");
        tvFacturaCliente.setText("Nombre: "+ cliente.getName() +" " + cliente.getLastname() + "   Dirección: " + cliente.getDirection());
        tvFacturaCompra1.setText(datospr1);
        tvFacturaCompra2.setText(datospr2);
        tvFacturaCompra3.setText(datospr3);
        tvFacturaCompra4.setText(datospr4);
        tvFacturaCompra5.setText(datospr5);
        tvFacturaCompra6.setText(datospr6);
        tvFacturaPrecio1.setText(datospre1);
        tvFacturaPrecio2.setText(datospre2);
        tvFacturaPrecio3.setText(datospre3);
        tvFacturaPrecio4.setText(datospre4);
        tvFacturaPrecio5.setText(datospre5);
        tvFacturaPrecio6.setText(datospre6);
        tvFacturaTotalP.setText(Totalp);
    }
}
