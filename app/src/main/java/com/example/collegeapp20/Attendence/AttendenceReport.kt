package com.example.collegeapp.Attendence

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.collegeapp20.Attendence.StudentInfo
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun AttendenceReport(){

    val db = Firebase.firestore

    val context= LocalContext.current
    var rollno by remember{
        mutableStateOf(" ")
    }

    var sname by remember {
        mutableStateOf("")
    }

    var course by remember {
        mutableStateOf(" ")
    }

    var percent by remember {
        mutableStateOf(" ")
    }

    var check by remember {
        mutableStateOf(false)
    }

    var report by remember {
        mutableStateOf(" ")
    }



    val database = Firebase.database
    val myRef = database.getReference("Students")


    Column(modifier= Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {

        Text(text = "Student Info from Firestore",
            fontSize = 20.sp,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = rollno, onValueChange ={rollno=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = {
                Text(text = " enter your id no")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = sname, onValueChange ={sname=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
          label = {
              Text(text = "enter Student name")
          }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = course, onValueChange ={course=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = {
                Text(text = "enter student course")
            }
        )
        
        Spacer(modifier = Modifier.height(10.dp))
        
        OutlinedTextField(value = percent, onValueChange = {percent=it},
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
       label = {
           Text(text = "enter student percent")
       })

        
        
        Spacer(modifier = Modifier.height(20.dp))

Row() {

            OutlinedButton(onClick = {
                if(rollno.isNotEmpty() && sname.isNotEmpty() && course.isNotEmpty() && percent.isNotEmpty()) {


                    val students = hashMapOf(
                        "rollno" to rollno,
                        "studentname" to sname,
                        "course" to course,
                    "percent" to percent
                    )


                    db.collection("students")
                        .add(students)
                        .addOnSuccessListener{ documentReference ->

                            Toast.makeText(context,"record insert with ID: ${documentReference.id}",Toast.LENGTH_SHORT).show()
                        }

                        .addOnFailureListener{ e ->

                            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show()

                        }


                }  else

                {
                    Toast.makeText(context,"please insert record first",Toast.LENGTH_SHORT).show()

                }


            }) {
                Text(text = " Insert", fontSize = 16.sp, color = Color.White)
            }





            OutlinedButton(onClick = {
                val data = StringBuffer()
                myRef.get().addOnSuccessListener{
                    if(it.exists()){
                        it.children.forEach { it->
                            data.append("\n Student Roll ="+it.child("roll no").value)
                            data.append("\n Student Name ="+it.child("sname").value)
                            data.append("\n Student Course ="+it.child("course").value)
                            data.append("\n Attendce percentage="+it.child("percent").value)
                            data.append("\n ................")
                        }
                        check=true
                        report=data.toString()
                    }
                }.addOnFailureListener {
                    Toast.makeText(context,"record not found",Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "Display ", fontSize = 16.sp, color = Color.White)
            }




            OutlinedButton(onClick = {


                if (rollno.isNotEmpty() && sname.isNotEmpty() && course.isNotEmpty() &&  percent.isNotEmpty()) {

                    val sinfo = mapOf<String,String>(
                        "rollno" to rollno,
                        "sname" to sname,
                        "courses" to course,
                        "percent" to percent
                    )

                    myRef.child("adarsh royal lavuluri").updateChildren(sinfo).addOnSuccessListener {
                        rollno=" "
                        sname=" "
                        course=" "
                        percent=" "
                        Toast.makeText(context,"record inserted",Toast.LENGTH_SHORT).show()



                    }.addOnFailureListener{
                        Toast.makeText(context,it.toString(),Toast.LENGTH_SHORT).show()

                    }

                } else {

                    Toast.makeText(context,"please Insert value first",Toast.LENGTH_SHORT).show()


                }

            }) {
                Text(text = "Update ", fontSize = 16.sp, color = Color.White)
            }







            OutlinedButton(onClick = {


                if(sname.isNotEmpty()){
                    myRef.child(sname).removeValue().addOnSuccessListener {
                        Toast.makeText(context,"record deleted",Toast.LENGTH_SHORT).show()

                    }.addOnFailureListener{
                        Toast.makeText(context,it.toString(),Toast.LENGTH_SHORT).show()

                    }
                }else {
                    Toast.makeText(context,"please Insert name to delete record",Toast.LENGTH_SHORT).show()



                }


            }) {
                Text(text = " Delete", fontSize = 16.sp, color = Color.White)
            }
        }
    Spacer(modifier = Modifier.height(10.dp))
    AnimatedVisibility(visible = check,modifier= Modifier.fillMaxWidth()) {
        Text(text = report, fontSize = 14.sp, color = Color.Blue )
    }



        }


}



@Preview
@Composable
fun AttendenceReportPreview(){
    AttendenceReport()
}