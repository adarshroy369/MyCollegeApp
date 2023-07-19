package com.example.collegeapp20.Department.Faculity


import android.annotation.SuppressLint
import com.example.collegeapp20.R

class DataSource {

    @SuppressLint("ResourceType")
    fun loadDepartmentDetails():List<DepartmentDetails>{

        return listOf<DepartmentDetails>(
            DepartmentDetails(
             nameRes = R.string.Mr_MalliKarajunaNandi,
                descriptionRes = R.string.description1,
                imageRes = R.drawable.mallikarjunasir
            )
               ,     DepartmentDetails(
                nameRes = R.string.Mr_BUthapatiSampathBabu,
                descriptionRes = R.string.description2,
                imageRes = R.drawable.sampathsir
            )
                    , DepartmentDetails(
                nameRes = R.string.Mrs_MVinitha,
                descriptionRes = R.string.description3,
                imageRes = R.drawable.vinithamam
            )
            , DepartmentDetails(
                nameRes = R.string.Soumya,
                descriptionRes = R.string.description1,
                imageRes = R.drawable.soumayamam
            )
                    , DepartmentDetails(
                nameRes = R.string.Ms_PSindhu,
                descriptionRes = R.string.description1,
                imageRes = R.drawable.sindhumam
            )
                    , DepartmentDetails(
                nameRes = R.string.Ms_BShirieesha,
                descriptionRes = R.string.description1,
                imageRes = R.drawable.sirishamam
            )
                    , DepartmentDetails(
                nameRes = R.string.Mr_KrishnaManam,
                descriptionRes = R.string.description1,
                imageRes = R.drawable.krishnamanansir
            )

                    , DepartmentDetails(
                nameRes = R.string.mohan,
                descriptionRes = R.string.GuestFaculity,
                imageRes = R.drawable.mohansir
            ))

    }
}