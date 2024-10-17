package unipar.edu.atividade_01_b2_github.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import unipar.edu.atividade_01_b2_github.R
import unipar.edu.atividade_01_b2_github.data.Person

class Adapter(private val itemList: List<Person>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewSurname: TextView = itemView.findViewById(R.id.textViewSurname)
        val textViewAge: TextView = itemView.findViewById(R.id.textViewAge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val person = itemList[position]
        holder.textViewName.text = person.name
        holder.textViewSurname.text = person.surname
        holder.textViewAge.text = person.age.toString()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
