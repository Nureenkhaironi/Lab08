package com.nureenkhaironi.lab08

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.telecom.Call.Details
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nureenkhaironi.lab08.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val pizzaSize = arrayListOf("Small", "Medium", "Large", "Extra Large")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                binding.sizeTextView.text = pizzaSize[p1]
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                print("Start tracking")

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                print("Stop tracking")
            }

        })

        binding.scheduleButton.setOnClickListener {

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("name", binding.nameEditText.text.toString())
            intent.putExtra("phone", binding.phoneEditText.text.toString())
            intent.putExtra("size", binding.sizeTextView.text.toString())
            intent.putExtra("date", binding.dateTextView.text.toString())
            intent.putExtra("time", binding.timeTextView.text.toString())
            startActivity(intent)
        }

        binding.dateButton.setOnClickListener {
             //dapatkan tarikh hari ini
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)


                //Create a DatePickerDialog
            val myDatePicker = DatePickerDialog(this,
                android.R.style.ThemeOverlay,

                //Listener - Bila tarikh dipilih
                //i3 = day, i2 = month, i=year
                //month mula dari 0, jadi tambahkan 1 untuk january for example
            DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                //letak tarikh yang dipilih pada dateTextView
                binding.dateTextView.text= "$i3/${i2+1}/$i"
            } , year,month,day //Default date untuk diset pada datepicker bila ia ditukar
            )
                //show the datepicker
                myDatePicker.show()

        }

        binding.timeButton.setOnClickListener {

            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            val myTimePicker = TimePickerDialog(this,
                TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                    binding.timeTextView.text = "$i:$i2"

                }, hour, minute, false)

            myTimePicker.show()

        }

        }
    }
