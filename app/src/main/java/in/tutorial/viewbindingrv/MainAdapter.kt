package `in`.tutorial.viewbindingrv

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import `in`.tutorial.viewbindingrv.databinding.RecyclerviewItemBinding

class MainAdapter(val taskList:List<Task>):RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    inner class MainViewHolder(val itemBinding: RecyclerviewItemBinding):
                    RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(task: Task) {
            itemBinding.titleTV.text = task.title
            itemBinding.timeTv.text = task.timestamp
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),
                parent, false))
    }

    override fun getItemCount(): Int {
        Log.e("errorSize", "${taskList.size}")
        return taskList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task = taskList[position]
        Log.e("errorSize", "binding ${task.title    }")
        holder.bindItem(task)
    }
}