package es.avifer.listheaderseemore

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginStart
import androidx.core.view.marginTop
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@Suppress("MemberVisibilityCanBePrivate")
class ListHeaderSeeMore(context: Context, attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {

    companion object {
        private var DEFAULT_BACKGROUND_COLOR = R.color.white

        private var DEFAULT_TEXT_HEADER = ""
        private var DEFAULT_COLOR_TEXT_HEADER = R.color.black
        private var DEFAULT_SIZE_TEXT_HEADER = 12
        private var DEFAULT_MAX_LINES_HEADER = 1
        private var DEFAULT_PADDING_TEXT_HEADER = -999999999
        private var DEFAULT_PADDING_HORIZONTAL_TEXT_HEADER = -999999999
        private var DEFAULT_PADDING_VERTICAL_TEXT_HEADER = -999999999
        private var DEFAULT_MARGIN_TEXT_HEADER = -999999999
        private var DEFAULT_MARGIN_HORIZONTAL_TEXT_HEADER = -999999999
        private var DEFAULT_MARGIN_VERTICAL_TEXT_HEADER = -999999999

        private var DEFAULT_TEXT_SEE_MORE = ""
        private var DEFAULT_COLOR_TEXT_SEE_MORE = R.color.black
        private var DEFAULT_SIZE_TEXT_SEE_MORE = 12
        private var DEFAULT_MAX_LINES_SEE_MORE = 1
        private var DEFAULT_PADDING_TEXT_SEE_MORE = -999999999
        private var DEFAULT_PADDING_HORIZONTAL_TEXT_SEE_MORE = -999999999
        private var DEFAULT_PADDING_VERTICAL_TEXT_SEE_MORE = -999999999
        private var DEFAULT_MARGIN_TEXT_SEE_MORE = -999999999
        private var DEFAULT_MARGIN_HORIZONTAL_TEXT_SEE_MORE = -999999999
        private var DEFAULT_MARGIN_VERTICAL_TEXT_SEE_MORE = -999999999

        private var DEFAULT_PADDING_LIST_ELEMENTS = -999999999
        private var DEFAULT_PADDING_HORIZONTAL_LIST_ELEMENTS = -999999999
        private var DEFAULT_PADDING_VERTICAL_LIST_ELEMENTS = -999999999
        private var DEFAULT_MARGIN_LIST_ELEMENTS = -999999999
        private var DEFAULT_MARGIN_HORIZONTAL_LIST_ELEMENTS = -999999999
        private var DEFAULT_MARGIN_VERTICAL_LIST_ELEMENTS = -999999999
    }

    //VIEWS
    private var constraintLayoutParent: ConstraintLayout? = null
    private var headerLabel: TextView? = null
    private var seeMoreLabel: TextView? = null
    private var listElements: RecyclerView? = null

    //ATTRIBUTES
    private var attributes: TypedArray? = null

    init {
        inflate(context, R.layout.view__list_header_see_more, this)
        this.attributes =
            context.obtainStyledAttributes(attributeSet, R.styleable.ListHeaderSeeMore)
        initParentView()
        initHeaderTitle()
        initSeeMore()
        initListElements()
    }

    //region INIT VIEW

    private fun initParentView() {
        constraintLayoutParent = findViewById(R.id.view__list_header_see_more__constraint__parent)
        initBackgroundColorParentView()
    }

    private fun initBackgroundColorParentView() {
        setBackgroundColorParentView(
            this.attributes?.getColor(
                R.styleable.ListHeaderSeeMore_backgroundColor,
                ContextCompat.getColor(context, DEFAULT_BACKGROUND_COLOR)
            ) ?: ContextCompat.getColor(context, DEFAULT_BACKGROUND_COLOR)
        )
    }

    //endregion

    //region INIT HEADER TITLE

    private fun initHeaderTitle() {
        headerLabel = findViewById(R.id.view__list_header_see_more__label__header)
        initTextHeader()
        initColorTextHeader()
        initSizeTextHeader()
        initMaxLinesTextHeader()
        initPaddingTextHeader()
        initPaddingHorizontalTextHeader()
        initPaddingVerticalTextHeader()
        initMarginTextHeader()
        initMarginHorizontalTextHeader()
        initMarginVerticalTextHeader()
    }

    private fun initTextHeader() {
        setTextHeader(
            this.attributes?.getString(R.styleable.ListHeaderSeeMore_textHeader)
                ?: DEFAULT_TEXT_HEADER
        )
    }

    private fun initColorTextHeader() {
        setColorTextHeader(
            this.attributes?.getColor(
                R.styleable.ListHeaderSeeMore_colorTextHeader,
                ContextCompat.getColor(context, DEFAULT_COLOR_TEXT_HEADER)
            ) ?: ContextCompat.getColor(context, DEFAULT_COLOR_TEXT_HEADER)
        )
    }

    private fun initSizeTextHeader() {
        setSizeTextHeader(
            this.attributes?.getDimensionPixelSize(
                R.styleable.ListHeaderSeeMore_sizeTextHeader,
                DEFAULT_SIZE_TEXT_HEADER
            ) ?: DEFAULT_SIZE_TEXT_HEADER
        )
    }

    private fun initMaxLinesTextHeader() {
        setMaxLinesTextHeader(
            this.attributes?.getInt(
                R.styleable.ListHeaderSeeMore_maxLinesTextHeader,
                DEFAULT_MAX_LINES_HEADER
            ) ?: DEFAULT_MAX_LINES_HEADER
        )
    }

    private fun initPaddingTextHeader() {
        val paddingTextHeader = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingTextHeader,
            DEFAULT_PADDING_TEXT_HEADER
        ) ?: DEFAULT_PADDING_TEXT_HEADER

        if (paddingTextHeader != DEFAULT_PADDING_TEXT_HEADER) {
            setPaddingTextHeader(paddingTextHeader)
        }
    }

    private fun initPaddingHorizontalTextHeader() {
        val paddingHorizontalTextHeader = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingHorizontalTextHeader,
            DEFAULT_PADDING_HORIZONTAL_TEXT_HEADER
        ) ?: DEFAULT_PADDING_HORIZONTAL_TEXT_HEADER

        if (paddingHorizontalTextHeader != DEFAULT_PADDING_HORIZONTAL_TEXT_HEADER) {
            setPaddingHorizontalTextHeader(paddingHorizontalTextHeader)
        }
    }

    private fun initPaddingVerticalTextHeader() {
        val paddingVerticalTextHeader = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingVerticalTextHeader,
            DEFAULT_PADDING_VERTICAL_TEXT_HEADER
        ) ?: DEFAULT_PADDING_VERTICAL_TEXT_HEADER

        if (paddingVerticalTextHeader != DEFAULT_PADDING_VERTICAL_TEXT_HEADER) {
            setPaddingVerticalTextHeader(paddingVerticalTextHeader)
        }
    }

    private fun initMarginTextHeader() {
        val marginTextHeader = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginTextHeader,
            DEFAULT_MARGIN_TEXT_HEADER
        ) ?: DEFAULT_MARGIN_TEXT_HEADER

        if (marginTextHeader != DEFAULT_MARGIN_TEXT_HEADER) {
            setMarginTextHeader(marginTextHeader)
        }
    }

    private fun initMarginHorizontalTextHeader() {
        val marginHorizontalTextHeader = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginHorizontalTextHeader,
            DEFAULT_MARGIN_HORIZONTAL_TEXT_HEADER
        ) ?: DEFAULT_MARGIN_HORIZONTAL_TEXT_HEADER

        if (marginHorizontalTextHeader != DEFAULT_MARGIN_HORIZONTAL_TEXT_HEADER) {
            setMarginHorizontalTextHeader(marginHorizontalTextHeader)
        }
    }

    private fun initMarginVerticalTextHeader() {
        val marginVerticalTextHeader = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginVerticalTextHeader,
            DEFAULT_MARGIN_VERTICAL_TEXT_HEADER
        ) ?: DEFAULT_MARGIN_VERTICAL_TEXT_HEADER

        if (marginVerticalTextHeader != DEFAULT_MARGIN_VERTICAL_TEXT_HEADER) {
            setMarginVerticalTextHeader(marginVerticalTextHeader)
        }
    }

    //endregion

    //region INIT HEADER SEE MORE

    private fun initSeeMore() {
        seeMoreLabel = findViewById(R.id.view__list_header_see_more__label__see_more)
        initTextSeeMore()
        initColorTextSeeMore()
        initSizeTextSeeMore()
        initMaxLinesTextSeeMore()
        initPaddingTextSeeMore()
        initPaddingHorizontalTextSeeMore()
        initPaddingVerticalTextSeeMore()
        initMarginTextSeeMore()
        initMarginHorizontalTextSeeMore()
        initMarginVerticalTextSeeMore()
    }

    private fun initTextSeeMore() {
        setTextSeeMore(
            this.attributes?.getString(R.styleable.ListHeaderSeeMore_textSeeMore)
                ?: DEFAULT_TEXT_SEE_MORE
        )
    }

    private fun initColorTextSeeMore() {
        setColorTextSeeMore(
            this.attributes?.getColor(
                R.styleable.ListHeaderSeeMore_colorTextSeeMore,
                ContextCompat.getColor(context, DEFAULT_COLOR_TEXT_SEE_MORE)
            ) ?: ContextCompat.getColor(context, DEFAULT_COLOR_TEXT_SEE_MORE)
        )
    }

    private fun initSizeTextSeeMore() {
        setSizeTextSeeMore(
            this.attributes?.getDimensionPixelSize(
                R.styleable.ListHeaderSeeMore_sizeTextSeeMore,
                DEFAULT_SIZE_TEXT_SEE_MORE
            ) ?: DEFAULT_SIZE_TEXT_SEE_MORE
        )
    }

    private fun initMaxLinesTextSeeMore() {
        setMaxLinesTextSeeMore(
            this.attributes?.getInt(
                R.styleable.ListHeaderSeeMore_maxLinesTextSeeMore,
                DEFAULT_MAX_LINES_SEE_MORE
            ) ?: DEFAULT_MAX_LINES_SEE_MORE
        )
    }

    private fun initPaddingTextSeeMore() {
        val paddingTextSeeMore = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingTextSeeMore,
            DEFAULT_PADDING_TEXT_SEE_MORE
        ) ?: DEFAULT_PADDING_TEXT_SEE_MORE

        if (paddingTextSeeMore != DEFAULT_PADDING_TEXT_SEE_MORE) {
            setPaddingTextSeeMore(paddingTextSeeMore)
        }
    }

    private fun initPaddingHorizontalTextSeeMore() {
        val paddingHorizontalTextSeeMore = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingHorizontalTextSeeMore,
            DEFAULT_PADDING_HORIZONTAL_TEXT_SEE_MORE
        ) ?: DEFAULT_PADDING_HORIZONTAL_TEXT_SEE_MORE

        if (paddingHorizontalTextSeeMore != DEFAULT_PADDING_HORIZONTAL_TEXT_SEE_MORE) {
            setPaddingHorizontalTextSeeMore(paddingHorizontalTextSeeMore)
        }
    }

    private fun initPaddingVerticalTextSeeMore() {
        val paddingVerticalTextSeeMore = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingVerticalTextSeeMore,
            DEFAULT_PADDING_VERTICAL_TEXT_SEE_MORE
        ) ?: DEFAULT_PADDING_VERTICAL_TEXT_SEE_MORE

        if (paddingVerticalTextSeeMore != DEFAULT_PADDING_VERTICAL_TEXT_SEE_MORE) {
            setPaddingVerticalTextSeeMore(paddingVerticalTextSeeMore)
        }
    }

    private fun initMarginTextSeeMore() {
        val marginTextSeeMore = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginTextSeeMore,
            DEFAULT_MARGIN_TEXT_SEE_MORE
        ) ?: DEFAULT_MARGIN_TEXT_SEE_MORE

        if (marginTextSeeMore != DEFAULT_MARGIN_TEXT_SEE_MORE) {
            setMarginTextSeeMore(marginTextSeeMore)
        }
    }

    private fun initMarginHorizontalTextSeeMore() {
        val marginHorizontalTextSeeMore = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginHorizontalTextSeeMore,
            DEFAULT_MARGIN_HORIZONTAL_TEXT_SEE_MORE
        ) ?: DEFAULT_MARGIN_HORIZONTAL_TEXT_SEE_MORE

        if (marginHorizontalTextSeeMore != DEFAULT_MARGIN_HORIZONTAL_TEXT_SEE_MORE) {
            setMarginHorizontalTextSeeMore(marginHorizontalTextSeeMore)
        }
    }

    private fun initMarginVerticalTextSeeMore() {
        val marginVerticalTextSeeMore = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginVerticalTextSeeMore,
            DEFAULT_MARGIN_VERTICAL_TEXT_SEE_MORE
        ) ?: DEFAULT_MARGIN_VERTICAL_TEXT_SEE_MORE

        if (marginVerticalTextSeeMore != DEFAULT_MARGIN_VERTICAL_TEXT_SEE_MORE) {
            setMarginVerticalTextSeeMore(marginVerticalTextSeeMore)
        }
    }

    //endregion

    //region INIT LIST ELEMENTS

    private fun initListElements() {
        listElements = findViewById(R.id.view__list_header_see_more__list__elements)
        initLayoutManagerList()
        initPaddingListElements()
        initPaddingHorizontalListElements()
        initPaddingVerticalListElements()
        initMarginListElements()
        initMarginHorizontalListElements()
        initMarginVerticalListElements()
    }

    private fun initLayoutManagerList() {
        listElements?.let {
            with(it) {
                layoutManager =
                    object : LinearLayoutManager(context, HORIZONTAL, false) {
                        override fun canScrollVertically() = false
                    }
            }
        }
    }

    private fun initPaddingListElements() {
        val paddingListElements = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingList,
            DEFAULT_PADDING_LIST_ELEMENTS
        ) ?: DEFAULT_PADDING_LIST_ELEMENTS

        if (paddingListElements != DEFAULT_PADDING_LIST_ELEMENTS) {
            setPaddingListElements(paddingListElements)
        }
    }

    private fun initPaddingHorizontalListElements() {
        val paddingHorizontalListElements = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingHorizontalList,
            DEFAULT_PADDING_HORIZONTAL_LIST_ELEMENTS
        ) ?: DEFAULT_PADDING_HORIZONTAL_LIST_ELEMENTS

        if (paddingHorizontalListElements != DEFAULT_PADDING_HORIZONTAL_LIST_ELEMENTS) {
            setPaddingHorizontalListElements(paddingHorizontalListElements)
        }
    }

    private fun initPaddingVerticalListElements() {
        val paddingVerticalListElements = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_paddingVerticalList,
            DEFAULT_PADDING_VERTICAL_LIST_ELEMENTS
        ) ?: DEFAULT_PADDING_VERTICAL_LIST_ELEMENTS

        if (paddingVerticalListElements != DEFAULT_PADDING_VERTICAL_LIST_ELEMENTS) {
            setPaddingVerticalListElements(paddingVerticalListElements)
        }
    }

    private fun initMarginListElements() {
        val marginListElements = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginList,
            DEFAULT_MARGIN_LIST_ELEMENTS
        ) ?: DEFAULT_MARGIN_LIST_ELEMENTS

        if (marginListElements != DEFAULT_MARGIN_LIST_ELEMENTS) {
            setMarginListElements(marginListElements)
        }
    }

    private fun initMarginHorizontalListElements() {
        val marginHorizontalListElements = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginHorizontalList,
            DEFAULT_MARGIN_HORIZONTAL_LIST_ELEMENTS
        ) ?: DEFAULT_MARGIN_HORIZONTAL_LIST_ELEMENTS

        if (marginHorizontalListElements != DEFAULT_MARGIN_HORIZONTAL_LIST_ELEMENTS) {
            setMarginHorizontalListElements(marginHorizontalListElements)
        }
    }

    private fun initMarginVerticalListElements() {
        val marginVerticalListElements = this.attributes?.getLayoutDimension(
            R.styleable.ListHeaderSeeMore_marginVerticalList,
            DEFAULT_MARGIN_VERTICAL_LIST_ELEMENTS
        ) ?: DEFAULT_MARGIN_VERTICAL_LIST_ELEMENTS

        if (marginVerticalListElements != DEFAULT_MARGIN_VERTICAL_LIST_ELEMENTS) {
            setMarginVerticalListElements(marginVerticalListElements)
        }
    }

    //endregion

    //region MODIFIERS VIEW

    fun setBackgroundColorParentView(color: Int) {
        constraintLayoutParent?.setBackgroundColor(color)
    }

    //endregion

    //region MODIFIERS TITLE

    fun setTextHeader(textHeader: String) {
        headerLabel?.text = textHeader
    }

    fun setColorTextHeader(color: Int) {
        headerLabel?.setTextColor(color)
    }

    fun setSizeTextHeader(size: Int) {
        headerLabel?.setTextSize(TypedValue.COMPLEX_UNIT_PX, size.toFloat())
    }

    fun setMaxLinesTextHeader(maxLines: Int) {
        headerLabel?.maxLines = maxLines
    }

    fun setPaddingTextHeader(padding: Int) {
        headerLabel?.setPadding(
            padding,
            padding,
            padding,
            padding
        )
    }

    fun setPaddingHorizontalTextHeader(paddingHorizontal: Int) {
        val paddingTop = headerLabel?.paddingTop ?: 0
        val paddingBottom = headerLabel?.paddingBottom ?: 0

        headerLabel?.setPadding(
            paddingHorizontal,
            paddingTop,
            paddingHorizontal,
            paddingBottom
        )
    }

    fun setPaddingVerticalTextHeader(paddingVertical: Int) {
        val paddingStart = headerLabel?.paddingStart ?: 0
        val paddingEnd = headerLabel?.paddingEnd ?: 0

        headerLabel?.setPadding(
            paddingStart,
            paddingVertical,
            paddingEnd,
            paddingVertical
        )
    }

    fun setMarginTextHeader(margin: Int) {
        (headerLabel?.layoutParams as? MarginLayoutParams)?.setMargins(
            margin,
            margin,
            margin,
            margin
        )
    }

    fun setMarginHorizontalTextHeader(marginHorizontal: Int) {
        val marginTop = headerLabel?.marginTop ?: 0
        val marginBottom = headerLabel?.marginBottom ?: 0

        (headerLabel?.layoutParams as? MarginLayoutParams)?.setMargins(
            marginHorizontal,
            marginTop,
            marginHorizontal,
            marginBottom
        )
    }

    fun setMarginVerticalTextHeader(marginVertical: Int) {
        val marginStart = headerLabel?.marginStart ?: 0
        val marginEnd = headerLabel?.marginEnd ?: 0

        (headerLabel?.layoutParams as? MarginLayoutParams)?.setMargins(
            marginStart,
            marginVertical,
            marginEnd,
            marginVertical
        )
    }

    //endregion

    //region MODIFIERS SEE MORE

    fun setTextSeeMore(textSeeMore: String) {
        seeMoreLabel?.text = textSeeMore
    }

    fun setColorTextSeeMore(color: Int) {
        seeMoreLabel?.setTextColor(color)
    }

    fun setSizeTextSeeMore(size: Int) {
        seeMoreLabel?.setTextSize(TypedValue.COMPLEX_UNIT_PX, size.toFloat())
    }

    fun setMaxLinesTextSeeMore(maxLines: Int) {
        seeMoreLabel?.maxLines = maxLines
    }

    fun setPaddingTextSeeMore(padding: Int) {
        seeMoreLabel?.setPadding(
            padding,
            padding,
            padding,
            padding
        )
    }

    fun setPaddingHorizontalTextSeeMore(paddingHorizontal: Int) {
        val paddingTop = seeMoreLabel?.paddingTop ?: 0
        val paddingBottom = seeMoreLabel?.paddingBottom ?: 0

        seeMoreLabel?.setPadding(
            paddingHorizontal,
            paddingTop,
            paddingHorizontal,
            paddingBottom
        )
    }

    fun setPaddingVerticalTextSeeMore(paddingVertical: Int) {
        val paddingStart = seeMoreLabel?.paddingStart ?: 0
        val paddingEnd = seeMoreLabel?.paddingEnd ?: 0

        seeMoreLabel?.setPadding(
            paddingStart,
            paddingVertical,
            paddingEnd,
            paddingVertical
        )
    }

    fun setMarginTextSeeMore(margin: Int) {
        (seeMoreLabel?.layoutParams as? MarginLayoutParams)?.setMargins(
            margin,
            margin,
            margin,
            margin
        )
    }

    fun setMarginHorizontalTextSeeMore(marginHorizontal: Int) {
        val marginTop = seeMoreLabel?.marginTop ?: 0
        val marginBottom = seeMoreLabel?.marginBottom ?: 0

        (seeMoreLabel?.layoutParams as? MarginLayoutParams)?.setMargins(
            marginHorizontal,
            marginTop,
            marginHorizontal,
            marginBottom
        )
    }

    fun setMarginVerticalTextSeeMore(marginVertical: Int) {
        val marginStart = seeMoreLabel?.marginStart ?: 0
        val marginEnd = seeMoreLabel?.marginEnd ?: 0

        (seeMoreLabel?.layoutParams as? MarginLayoutParams)?.setMargins(
            marginStart,
            marginVertical,
            marginEnd,
            marginVertical
        )
    }

    fun setOnClickSeeMore(actionClick: () -> Unit) {
        seeMoreLabel?.setOnClickListener { actionClick() }
    }

    //endregion

    //region MODIFIERS LIST ELEMENTS

    fun <T> setAdapter(adapterList: ListHeaderSeeMoreAdapter<T>) {
        listElements?.adapter = adapterList
    }

    fun setPaddingListElements(padding: Int) {
        listElements?.setPadding(
            padding,
            padding,
            padding,
            padding
        )
    }

    fun setPaddingHorizontalListElements(paddingHorizontal: Int) {
        val paddingTop = listElements?.paddingTop ?: 0
        val paddingBottom = listElements?.paddingBottom ?: 0

        listElements?.setPadding(
            paddingHorizontal,
            paddingTop,
            paddingHorizontal,
            paddingBottom
        )
    }

    fun setPaddingVerticalListElements(paddingVertical: Int) {
        val paddingStart = listElements?.paddingStart ?: 0
        val paddingEnd = listElements?.paddingEnd ?: 0

        listElements?.setPadding(
            paddingStart,
            paddingVertical,
            paddingEnd,
            paddingVertical
        )
    }

    fun setMarginListElements(margin: Int) {
        (listElements?.layoutParams as? MarginLayoutParams)?.setMargins(
            margin,
            margin,
            margin,
            margin
        )
    }

    fun setMarginHorizontalListElements(marginHorizontal: Int) {
        val marginTop = listElements?.marginTop ?: 0
        val marginBottom = listElements?.marginBottom ?: 0

        (listElements?.layoutParams as? MarginLayoutParams)?.setMargins(
            marginHorizontal,
            marginTop,
            marginHorizontal,
            marginBottom
        )
    }

    fun setMarginVerticalListElements(marginVertical: Int) {
        val marginStart = listElements?.marginStart ?: 0
        val marginEnd = listElements?.marginEnd ?: 0

        (listElements?.layoutParams as? MarginLayoutParams)?.setMargins(
            marginStart,
            marginVertical,
            marginEnd,
            marginVertical
        )
    }

    //endregion

}

abstract class ListHeaderSeeMoreAdapter<T>(diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, RecyclerView.ViewHolder>(diffUtil)