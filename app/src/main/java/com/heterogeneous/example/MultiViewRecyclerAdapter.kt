import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.heterogeneous.multipleviewtypeexample.R

/**
 * @author Ravi
 */
class MultiViewRecyclerAdapter(private val context: Context, private val listViewType: List<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val ITEM_HEADER_VIEW = 1
        const val ITEM_OFFER_VIEW = 2
        const val ITEM_RESTAURANT_VIEW = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_HEADER_VIEW -> ViewHolderText(inflater.inflate(R.layout.item_text_offer, parent, false))
            ITEM_OFFER_VIEW -> ViewHolderImage(inflater.inflate(R.layout.item_image_offer, parent, false))
            ITEM_RESTAURANT_VIEW -> ViewHolderImageText(inflater.inflate(R.layout.item_image_text_offer, parent, false))
            else -> throw IllegalArgumentException("No Holder")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (listViewType[position]) {
            ITEM_HEADER_VIEW -> {
                val viewHolderText = holder as ViewHolderText
                viewHolderText.textView.text = context.getString(R.string.new_offers_amp_discount)
            }
            ITEM_OFFER_VIEW -> {
                val viewHolderImage = holder as ViewHolderImage
                viewHolderImage.offerImage.setBackgroundResource(if (position == 1) R.drawable.image_offer else R.drawable.zomoto_offer2)
            }
            ITEM_RESTAURANT_VIEW -> {
                val restaurantViewHolder = holder as ViewHolderImageText
                restaurantViewHolder.restaurantText.text = context.getString(R.string.hotel_offer_desc)
                restaurantViewHolder.restaurantImage.setBackgroundResource(if (position == 2) R.drawable.pizza else R.drawable.food_menu)
            }
            else -> {
                throw IllegalArgumentException("No Bind Holder")
            }
        }
    }

    override fun getItemCount(): Int = listViewType.size

    override fun getItemViewType(position: Int): Int = listViewType[position]

    //View holders for each unique view type
    inner class ViewHolderText(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textview_avail_offer)
    }

    inner class ViewHolderImage(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val offerImage: ImageView = itemView.findViewById(R.id.imageview_offer)
    }

    inner class ViewHolderImageText(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val restaurantText: TextView = itemView.findViewById(R.id.textview_restaurant)
        val restaurantImage: ImageView = itemView.findViewById(R.id.imageview_food_image)
    }
}