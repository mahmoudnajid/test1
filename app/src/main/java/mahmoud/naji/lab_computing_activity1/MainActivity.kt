package mahmoud.naji.lab_computing_activity1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //save to firebase
        btnSave.setOnClickListener {
            var name = edtName.text.toString()
            var id = edtId.text.toString()
            var age = edtAge.text.toString()

            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age
            )
            db.collection("Person")
                .add(person).addOnSuccessListener{ documentReference ->
                    Toast.makeText(applicationContext,"${documentReference.id}", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext,"$e", Toast.LENGTH_LONG).show()

                }



        }
    }
}