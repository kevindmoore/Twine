package com.mastertechsoftware.twine.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.mastertechsoftware.twine.R
import com.mastertechsoftware.twine.models.Deposit
import kotlinx.android.synthetic.main.deposit_item.*
import kotlinx.android.synthetic.main.deposits.*

/**
 * Show the list of Deposits
 */
class DepositsFragment : Fragment() {
    lateinit var viewModel: DepositsModel
    val adapter = DepositsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(DepositsModel::class.java)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.deposits, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        deposits.adapter = adapter
        viewModel.getDeposits() { deposits ->
            deposits?.let {
                adapter.deposits = it
            }
        }
    }

    class DepositsAdapter : RecyclerView.Adapter<ViewHolder>() {
        var deposits: List<Deposit> = arrayListOf()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        private var layoutInflator: LayoutInflater? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            if (layoutInflator == null) {
                layoutInflator = LayoutInflater.from(parent.context)
            }
            return ViewHolder(
                layoutInflator?.inflate(
                    R.layout.deposit_item,
                    parent,
                    false
                )!!
            )
        }

        override fun getItemCount(): Int = deposits.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val deposit = deposits[position]

            holder.depositName.text = deposit.name
        }

    }

}