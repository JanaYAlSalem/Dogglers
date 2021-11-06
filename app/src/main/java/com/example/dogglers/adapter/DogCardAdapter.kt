/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.R.layout.vertical_horizontal_list_item
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource


class DogCardAdapter(private val context: Context?,
                     private val layout: Int): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    //Initialize the data using the List found in data/DataSource
    val dataset = DataSource.dogs


    class DogCardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        // Initialize view elements
        val imgView: ImageView = view.findViewById(R.id.dog_image) // place of img on list item
        val textViewname: TextView = view.findViewById(R.id.nameOfdog) // place of text name on list item
        val textViewage: TextView = view.findViewById(R.id.ageOfdog) // place of text age on list item
        val textViewhobbies: TextView = view.findViewById(R.id.hobbiesOfdog) // place hobbies of text on list item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {

        // create a new view:ItemViewHolder and return it on ****
        // view called a adapterLayout which is get from parent to list_item layout
        val adapterLayoutGrid = LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item,parent,false)
        val adapterLayouthorizontal = LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item, parent, false)
        val adapterLayoutvertical = LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)
        val ElseNULL = LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)

        if (layout == Layout.GRID) {
            return DogCardViewHolder(adapterLayoutGrid)
        } else if (layout == Layout.HORIZONTAL) {
            return DogCardViewHolder(adapterLayouthorizontal)
        } else if (layout == Layout.VERTICAL) {
            return DogCardViewHolder(adapterLayoutvertical)
        } else
            return DogCardViewHolder(ElseNULL)
        }


    override fun getItemCount(): Int = dataset.size // dataset is initializes on ItemAdapter(constructor:type)

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // item is a af(the type of list) datatype
        // the holder is will be show on the screen
        val item = dataset[position]

        // imgView -> initializes on DogCardViewHolder class, imageResourceId is a constructor on Dog class
        holder.imgView.setImageResource(item.imageResourceId)

        // textViewname -> initializes on DogCardViewHolder class, name is a constructor on Dog class
        // holder.textViewname.setText(resources?.getString(R.string.app_name,item.name))
        holder.textViewname.text = item.name

        // textViewage -> initializes on DogCardViewHolder class, age is a constructor on Dog class
        holder.textViewage.text = "Age: ${item.age}"

        // textViewhobbies -> initializes on DogCardViewHolder class, hobbies is a constructor on Dog class
        val resources = context?.resources
        holder.textViewhobbies.text = resources?.getString(R.string.dog_hobbies, item.hobbies)

    }
}