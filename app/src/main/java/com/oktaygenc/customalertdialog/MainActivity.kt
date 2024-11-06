package com.oktaygenc.customalertdialog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.oktaygenc.customalertdialog.databinding.ActivityMainBinding
import com.oktaygenc.customalertdialog.databinding.CustomAlertDialogBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button.setOnClickListener {
            showCustomAlertDialog()
        }
    }

    private fun showCustomAlertDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val dialogBinding = CustomAlertDialogBinding.inflate(inflater)
        dialogBuilder.setView(dialogBinding.root)

        val alertDialog = dialogBuilder.create()

        dialogBinding.buttonCancel.setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this, "İptal edildi", Toast.LENGTH_SHORT).show()
        }

        dialogBinding.buttonConfirm.setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this, "Onaylandı", Toast.LENGTH_SHORT).show()
        }

        alertDialog.show()
    }
}