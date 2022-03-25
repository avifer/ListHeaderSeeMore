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
        private var DEFAULT_PADDING_HORIZONTAL_TEXT_HEADER = 0
        private var DEFAULT_PADDING_VERTICAL_TEXT_HEADER = 0
        private var DEFAULT_MARGIN_HORIZONTAL_TEXT_HEADER = 0
        private var DEFAULT_MARGIN_VERTICAL_TEXT_HEADER = 0

        private var DEFAULT_TEXT_SEE_MORE = ""
        private var DEFAULT_COLOR_TEXT_SEE_MORE = R.color.black
        private var DEFAULT_SIZE_TEXT_SEE_MORE = 12
        private var DEFAULT_MAX_LINES_SEE_MORE = 1
        private var DEFAULT_PADDING_HORIZONTAL_TEXT_SEE_MORE = 0
        private var DEFAULT_PADDING_VERTICAL_TEXT_SEE_MORE = 0
        private var DEFAULT_MARGIN_HORIZONTAL_TEXT_SEE_MORE = 0
        private var DEFAULT_MARGIN_VERTICAL_TEXT_SEE_MORE = 0

        private var DEFAULT_PADDING_HORIZONTAL_LIST_ELEMENTS = 0
        private var DEFAULT_PADDING_VERTICAL_LIST_ELEMENTS = 0
        private var DEFAULT_MARGIN_HORIZONTAL_LIST_ELEMENTS = 0
        private var DEFAULT_MARGIN_VERTICAL_LIST_ELEMENTS = 0
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
        initPaddingHorizontalTextHeader()
        initPaddingVerticalTextHeader()
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

    private fun initPaddingHorizontalTextHeader() {
        setPaddingHorizontalTextHeader(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_paddingHorizontalTextHeader,
                DEFAULT_PADDING_HORIZONTAL_TEXT_HEADER
            ) ?: DEFAULT_PADDING_HORIZONTAL_TEXT_HEADER
        )
    }

    private fun initPaddingVerticalTextHeader() {
        setPaddingVerticalTextHeader(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_paddingVerticalTextHeader,
                DEFAULT_PADDING_VERTICAL_TEXT_HEADER
            ) ?: DEFAULT_PADDING_VERTICAL_TEXT_HEADER
        )
    }

    private fun initMarginHorizontalTextHeader() {
        setMarginHorizontalTextHeader(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_marginHorizontalTextHeader,
                DEFAULT_MARGIN_HORIZONTAL_TEXT_HEADER
            ) ?: DEFAULT_MARGIN_HORIZONTAL_TEXT_HEADER
        )
    }

    private fun initMarginVerticalTextHeader() {
        setMarginVerticalTextHeader(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_marginVerticalTextHeader,
                DEFAULT_MARGIN_VERTICAL_TEXT_HEADER
            ) ?: DEFAULT_MARGIN_VERTICAL_TEXT_HEADER
        )
    }

    //endregion

    //region INIT HEADER SEE MORE

    private fun initSeeMore() {
        seeMoreLabel = findViewById(R.id.view__list_header_see_more__label__see_more)
        initTextSeeMore()
        initColorTextSeeMore()
        initSizeTextSeeMore()
        initMaxLinesTextSeeMore()
        initPaddingHorizontalTextSeeMore()
        initPaddingVerticalTextSeeMore()
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

    private fun initPaddingHorizontalTextSeeMore() {
        setPaddingHorizontalTextSeeMore(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_paddingHorizontalTextSeeMore,
                DEFAULT_PADDING_HORIZONTAL_TEXT_SEE_MORE
            ) ?: DEFAULT_PADDING_HORIZONTAL_TEXT_SEE_MORE
        )
    }

    private fun initPaddingVerticalTextSeeMore() {
        setPaddingVerticalTextSeeMore(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_paddingVerticalTextSeeMore,
                DEFAULT_PADDING_VERTICAL_TEXT_SEE_MORE
            ) ?: DEFAULT_PADDING_VERTICAL_TEXT_SEE_MORE
        )
    }

    private fun initMarginHorizontalTextSeeMore() {
        setMarginHorizontalTextSeeMore(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_marginHorizontalTextSeeMore,
                DEFAULT_MARGIN_HORIZONTAL_TEXT_SEE_MORE
            ) ?: DEFAULT_MARGIN_HORIZONTAL_TEXT_SEE_MORE
        )
    }

    private fun initMarginVerticalTextSeeMore() {
        setMarginVerticalTextSeeMore(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_marginVerticalTextSeeMore,
                DEFAULT_MARGIN_VERTICAL_TEXT_SEE_MORE
            ) ?: DEFAULT_MARGIN_VERTICAL_TEXT_SEE_MORE
        )
    }

    //endregion

    //region INIT LIST ELEMENTS

    private fun initListElements() {
        listElements = findViewById(R.id.view__list_header_see_more__list__elements)
        initLayoutManagerList()
        initPaddingHorizontalListElements()
        initPaddingVerticalListElements()
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

    private fun initPaddingHorizontalListElements() {
        setPaddingHorizontalListElements(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_paddingHorizontalList,
                DEFAULT_PADDING_HORIZONTAL_LIST_ELEMENTS
            ) ?: DEFAULT_PADDING_HORIZONTAL_LIST_ELEMENTS
        )
    }

    private fun initPaddingVerticalListElements() {
        setPaddingVerticalListElements(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_paddingVerticalList,
                DEFAULT_PADDING_VERTICAL_LIST_ELEMENTS
            ) ?: DEFAULT_PADDING_VERTICAL_LIST_ELEMENTS
        )
    }

    private fun initMarginHorizontalListElements() {
        setMarginHorizontalListElements(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_marginHorizontalList,
                DEFAULT_MARGIN_HORIZONTAL_LIST_ELEMENTS
            ) ?: DEFAULT_MARGIN_HORIZONTAL_LIST_ELEMENTS
        )
    }

    private fun initMarginVerticalListElements() {
        setMarginVerticalListElements(
            this.attributes?.getLayoutDimension(
                R.styleable.ListHeaderSeeMore_marginVerticalList,
                DEFAULT_MARGIN_VERTICAL_LIST_ELEMENTS
            ) ?: DEFAULT_MARGIN_VERTICAL_LIST_ELEMENTS
        )
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