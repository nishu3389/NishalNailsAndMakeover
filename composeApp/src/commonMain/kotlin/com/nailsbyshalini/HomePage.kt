package com.nailsbyshalini

import AppFontWeight
import Colors
import Sections
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nailsbyshalini.ui.AppText
import com.nailsbyshalini.ui.AppTextDecorative
import nishalnailsandmakeover.composeapp.generated.resources.Res
import nishalnailsandmakeover.composeapp.generated.resources.*
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


data class CardModel(val title: String, val image: DrawableResource)

@Composable
fun SpaceBetweenSections() {
    Spacer(Modifier.height(70.dp))
}

@Composable
fun TopBar(onClick: (Sections) -> Unit) {
    Box {
        Box {

            Row(
                modifier = Modifier.padding(end = 220.dp, top = 60.dp, bottom = 50.dp)
                    .align(alignment = AbsoluteAlignment.CenterRight),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {

                    AppText(
                        text = "Home",
                        weight = AppFontWeight.Medium,
                        fontSize = 16.sp,
                        fontColor = Color.Black,
                        modifier = Modifier.clickable { onClick.invoke(Sections.Home) })
                    AppText(
                        text = "Services",
                        weight = AppFontWeight.Medium,
                        fontSize = 16.sp,
                        fontColor = Color.Black,
                        modifier = Modifier.clickable { onClick.invoke(Sections.Services) })
                    AppText(
                        text = "Gallery",
                        weight = AppFontWeight.Medium,
                        fontSize = 16.sp,
                        fontColor = Color.Black,
                        modifier = Modifier.clickable { onClick.invoke(Sections.Gallery) })
                    AppText(
                        text = "About",
                        weight = AppFontWeight.Medium,
                        fontSize = 16.sp,
                        fontColor = Color.Black,
                        modifier = Modifier.clickable { onClick.invoke(Sections.About) })
                    AppText(
                        text = "Reviews",
                        weight = AppFontWeight.Medium,
                        fontSize = 16.sp,
                        fontColor = Color.Black,
                        modifier = Modifier.clickable { onClick.invoke(Sections.Reviews) })
                    AppText(
                        text = "Contact",
                        weight = AppFontWeight.Medium,
                        fontSize = 16.sp,
                        fontColor = Color.Black,
                        modifier = Modifier.clickable { onClick.invoke(Sections.Contact) })

                }

                Spacer(Modifier.width(35.dp))

                /*
                * Call Button
                * */
                Row(Modifier.background(color = Colors.Primary, shape = RoundedCornerShape(5.dp)),
                    verticalAlignment = Alignment.CenterVertically,) {
                    Spacer(Modifier.width(15.dp))
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = "Home",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(10.dp))
                    AppText(
                        text = "+91-97134 61786",
                        weight = AppFontWeight.Medium,
                        fontColor = Color.White,
                        fontSize = 17.sp,
                        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, end = 15.dp)
                    )
                }

            }

            /*
            * Underline
            * */
            Box(Modifier.height(0.5.dp).fillMaxWidth().background(Color.LightGray).align(alignment = Alignment.BottomCenter))

        }

        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "Company Logo",
            modifier = Modifier
                .height(200.dp).padding(start = 220.dp).align(alignment = Alignment.CenterStart)
                .background(color = Color(0xFFFFF3F3))
        )
    }
}

@Composable
fun HeroSection() {
    Row(
        Modifier.padding(start = 250.dp, end = 300.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(Modifier.height(70.dp))

            AppText(
                text = "Where Beauty Meets Artistry at",
                weight = AppFontWeight.Medium,
                fontSize = 24.sp
            )

            Spacer(Modifier.height(12.dp))

//            BeautyTagline(text = "Shalini Nails & Makeover")
//
            AppTextDecorative(
                text = "Shalini Nails & Makeover",
                weight = AppFontWeight.SemiBold,
                fontSize = 37.sp
            )

            Spacer(Modifier.height(20.dp))

            AppText(
                text = "Experience thoughtfully crafted nail and eyelash services that\n" +
                        "bring out your best look. From detailed nail art to\n" +
                        "eye-enhancing lashes and makeup, we focus on precision,\n" +
                        "comfort, and style. Book your session today and\n" +
                        "relax while we transform your beauty.",
                textAlign = TextAlign.Left,
                weight = AppFontWeight.Light,
                fontSize = 16.sp,
                fontColor = Colors.TextPrimary,
                extraLineHeight = true
            )

            Spacer(Modifier.height(60.dp))

            Row(Modifier.background(color = Colors.Primary, shape = RoundedCornerShape(5.dp))) {
                AppText(
                    text = "Book Appointment",
                    weight = AppFontWeight.SemiBold,
                    fontColor = Color.White,
                    fontSize = 15.sp,
                    modifier =
                    Modifier.padding(top = 12.dp, bottom = 12.dp, start = 17.dp, end = 17.dp)
                )
            }

        }

        Spacer(Modifier.height(20.dp))

        Card(
            modifier = Modifier.size(550.dp).padding(top = 0.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.big_image3),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }


    }
}

@Composable
fun ServicesSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        AppTextDecorative(
            text = "Our Services",
            weight = AppFontWeight.SemiBold,
            fontSize = 30.sp,
            fontColor = Colors.Primary
        )

        Spacer(Modifier.height(25.dp))

        AppText(
            text = "Enhance Your Natural Beauty with Our Premium Treatments",
            weight = AppFontWeight.Regular, fontSize = 18.sp, fontColor = Colors.TextPrimary
        )

        Spacer(Modifier.height(30.dp))

        AppText(
            text = "From elegant nail extensions to stunning eyelash and makeup services, Shalini Nails & Makeover is here to meet all your beauty needs.\n" +
                    "Our experienced artists use high-quality products to deliver\n" +
                    "comfort, care, and beautiful results.",
            weight = AppFontWeight.Light,
            fontSize = 16.sp,
            fontColor = Colors.TextPrimary,
            extraLineHeight = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(30.dp))

    }
}

@Composable
fun FlippingImageCard(
    frontImage: DrawableResource,
    backImage: DrawableResource,
    modifier: Modifier = Modifier,
    flipDuration: Int = 1200,
    autoFlipDelay: Long = 2500
) {
    var isFront by remember { mutableStateOf(true) }

    val rotation by animateFloatAsState(
        targetValue = if (isFront) 0f else 180f,
        animationSpec = tween(durationMillis = flipDuration),
        label = "flip"
    )

    // Auto flip
    LaunchedEffect(Unit) {
        while (true) {
            delay(autoFlipDelay)
            isFront = !isFront
        }
    }

    Card(
        modifier = modifier
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 12 * density
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Image(
            painter = painterResource(
                if (rotation <= 90f) frontImage else backImage
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                // Mirror the back image
                .graphicsLayer {
                    if (rotation > 90f) rotationY = 180f
                }
        )
    }
}


@Composable
fun FlippingImageCardWhenVisible(
    frontImage: DrawableResource,
    backImage: DrawableResource,
    modifier: Modifier = Modifier
) {
    var isFront by remember { mutableStateOf(true) }
    var isVisible by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (isFront) 0f else 180f,
        animationSpec = tween(1200),
        label = "flip"
    )

    // 🔥 Run animation only when visible
    LaunchedEffect(isVisible) {
        if (isVisible) {
            while (true) {
                delay(2500)
                isFront = !isFront
            }
        }
    }

    Card(
        modifier = modifier
            .onGloballyPositioned { coordinates ->
                val bounds = coordinates.boundsInWindow()

                val windowWidth = coordinates.size.width.toFloat()
                val windowHeight = coordinates.size.height.toFloat()

                isVisible =
                    bounds.right > 0 &&
                            bounds.left < windowWidth &&
                            bounds.bottom > 0 &&
                            bounds.top < windowHeight
            }
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 12 * density
            },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Image(
            painter = painterResource(
                if (rotation <= 90f) frontImage else backImage
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer {
                    if (rotation > 90f) rotationY = 180f
                }
        )
    }
}


@Composable
fun AboutSection() {
    Row(
        Modifier.padding(start = 350.dp, end = 150.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        FlippingImageCard(
            frontImage = Res.drawable.shalini,
            backImage = Res.drawable.shalini2,
            modifier = Modifier
                .width(450.dp)
                .height(700.dp)
        )

        Spacer(Modifier.width(50.dp))

        Column(
            modifier = Modifier
                .weight(1f),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(Modifier.height(50.dp))

            AppTextDecorative(
                text = "About Me",
                fontColor = Colors.Primary,
                weight = AppFontWeight.SemiBold, fontSize = 37.sp
            )

            Spacer(Modifier.height(15.dp))


            AppText(
                text = "A Passion for Beauty, Driven by Perfection",
                weight = AppFontWeight.Regular, fontSize = 18.sp, fontColor = Colors.TextPrimary
            )

            Spacer(Modifier.height(25.dp))

            AppText(
                text = "Shalini Nails & Makeover is a welcoming space where beauty\n" +
                        "is thoughtfully crafted with care and creativity. With years\n" +
                        "of hands-on experience, every service is delivered with\n" +
                        "precision, dedication, and attention to detail.\n\n" +
                        "We believe in using premium products and keeping up with\n" +
                        "modern beauty trends to offer refined, effective, and\n" +
                        "confidence-boosting beauty experiences.",
                textAlign = TextAlign.Left,
                weight = AppFontWeight.Light,
                fontSize = 16.sp,
                fontColor = Colors.TextPrimary,
                extraLineHeight = true
            )

            Spacer(Modifier.height(60.dp))

            Row(Modifier.background(color = Colors.Primary, shape = RoundedCornerShape(5.dp))) {
                AppText(
                    text = "Book Appointment",
                    weight = AppFontWeight.SemiBold,
                    fontColor = Color.White,
                    fontSize = 15.sp,
                    modifier =
                    Modifier.padding(top = 12.dp, bottom = 12.dp, start = 17.dp, end = 17.dp)
                )
            }

        }
    }
}

@Composable
fun SeeOurWork(onImageClicked: (Int) -> Unit, images: List<DrawableResource>) {

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 280.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppTextDecorative(
            text = "See Our Work",
            weight = AppFontWeight.SemiBold,
            fontSize = 30.sp,
            fontColor = Colors.Primary
        )

        Spacer(Modifier.height(25.dp))

        AppText(
            text = "Transformations That Reflect True Artistry",
            weight = AppFontWeight.Regular,
            fontSize = 18.sp,
            fontColor = Colors.TextPrimary
        )

        Spacer(Modifier.height(30.dp))

        AppText(
            text = "Explore the stunning beauty transformations we’ve brought to life. From soft, natural enhancements\n" +
                    "to bold and glamorous makeovers, every look is crafted to match your\n" +
                    "unique style and vision.",
            weight = AppFontWeight.Light,
            fontSize = 16.sp,
            fontColor = Colors.TextPrimary,
            extraLineHeight = true,
            modifier = Modifier.fillMaxWidth()
        )

        val space = remember { 25.dp }

        Spacer(Modifier.height(30.dp))

        ImageGrid(images){ index ->
            onImageClicked.invoke(index)
        }

    }
}

@Composable
fun ImageGrid(
    images: List<DrawableResource>,
    space: Dp = 16.dp,
    onImageClicked : (Int) -> Unit
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(space),
        modifier = Modifier.fillMaxWidth()
    ) {
        images.chunked(3).forEachIndexed { rowIndex, rowImages ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(space)
            ) {
                rowImages.forEachIndexed { colIndex, image ->

                    val index = rowIndex * 3 + colIndex // ⭐ IMPORTANT

                    HoverImageWork(
                        modifier = Modifier.weight(1f),
                        image = image,
                        index = index
                    ) { clickedIndex ->
                        onImageClicked.invoke(clickedIndex)
                    }
                }

                // Fill empty slots
                repeat(3 - rowImages.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }

}


@Composable
fun ClientReviews() {

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 280.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppTextDecorative(
            text = "Our Clients Speak!",
            weight = AppFontWeight.SemiBold,
            fontSize = 30.sp,
            fontColor = Colors.Primary
        )

        Spacer(Modifier.height(25.dp))

        AppText(
            text = "Real Stories. Real Satisfaction.",
            weight = AppFontWeight.Regular,
            fontSize = 18.sp,
            fontColor = Colors.TextPrimary
        )

        Spacer(Modifier.height(30.dp))

        AppText(
            text = "Read what our wonderful clients share about their experiences at Shalini Nails & Makeover. Their smiles,\n" +
                    "confidence, and positive feedback inspire us to deliver exceptional beauty services every time.",
            weight = AppFontWeight.Light,
            fontSize = 16.sp,
            fontColor = Colors.TextPrimary,
            extraLineHeight = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(50.dp))

        val list = remember { getReviewList() }

        Row(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(top = 80.dp, end = 50.dp)) {
                Image(
                    painter = painterResource(Res.drawable.rating1),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.graphicsLayer {
                        scaleX = 0.8f
                        scaleY = 0.8f
                    })
            }

            AutoSlidingReviews(items = list)

        }

    }
}

@Composable
fun CallSection() {

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 280.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(60.dp)
                .background(
                    color = Colors.Primary,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Call,
                contentDescription = "Call",
                tint = Color.White,
                modifier = Modifier.size(38.dp)
            )
        }



        Spacer(Modifier.height(25.dp))

        AppText(
            text = "Let Us Enhance Your Natural Beauty",
            weight = AppFontWeight.Regular,
            fontSize = 18.sp,
            fontColor = Colors.TextPrimary
        )

        Spacer(Modifier.height(30.dp))

        AppText(
            text = "Contact us today to schedule your session and experience beauty crafted with care at\n",
            weight = AppFontWeight.Light,
            fontSize = 16.sp,
            fontColor = Colors.TextPrimary,
            extraLineHeight = true,
            modifier = Modifier.fillMaxWidth()
        )

        AppText(
            text = "Shalini Nails & Makeover!",
            weight = AppFontWeight.Medium,
            fontSize = 16.sp,
            fontColor = Colors.TextPrimary,
            extraLineHeight = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .wrapContentWidth()
                .border(
                    width = 2.dp,
                    color = Colors.Primary,
                    shape = RoundedCornerShape(30.dp)
                ).padding(horizontal = 30.dp, vertical = 10.dp)
        ) {

            AppText(
                text = "+91 - 97134 61786",
                weight = AppFontWeight.Bold,
                fontSize = 30.sp,
                fontColor = Colors.Primary
            )
        }


    }
}

@Composable
fun DividerWithImage() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        SpaceBetweenSections()
        Image(
            painter = painterResource(Res.drawable.divider3),
            contentDescription = null,
            modifier = Modifier
        )
        SpaceBetweenSections()
    }
}


@Composable
fun GallerySection() {

    val list = remember { getList() }

    Column(Modifier.padding(horizontal = 280.dp)) {
        ImagesSection("Makeover", list, Modifier.padding(top = 30.dp))
        ImagesSection("Nail Extensions", list, Modifier.padding(top = 60.dp))
        ImagesSection("Eyelash Extensions", list, Modifier.padding(top = 60.dp))
    }
}

@Composable
fun FooterSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Spacer(Modifier.height(64.dp))
        AppText(
            text = "© 2025 Shalini Nails & Makeover",
            weight = AppFontWeight.Regular,
            fontColor = Colors.TextSecondary
        )
    }
}

@Composable
fun ImagesSection(sectionName: String, arrayList: List<CardModel>, modifier: Modifier = Modifier) {
    Column(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AppTextDecorative(
                modifier = Modifier.padding(end = 10.dp),
                text = sectionName,
                weight = AppFontWeight.Medium,
                fontSize = 24.sp,
                fontColor = Colors.Primary
            )
            Box(Modifier.background(Colors.Primary).height(2.dp).fillMaxWidth())
        }
        Spacer(Modifier.height(25.dp))

        AutoSlidingRow(items = arrayList)
    }
}

@Composable
fun AutoSlidingRow(
    items: List<CardModel>,
    itemWidth: Dp = 260.dp,
    spacing: Dp = 16.dp,
    autoScrollSpeed: Float = 1.5f,
    resumeDelay: Long = 100L
) {
    val listState = rememberLazyListState()
    val interactionSource = remember { MutableInteractionSource() }

    val isDragging by interactionSource.collectIsDraggedAsState()
    val isHovered by interactionSource.collectIsHoveredAsState()

    val userInteracting = isDragging || isHovered

    val infiniteItems = remember(items) { items + items }

    val snapFlingBehavior = rememberSnapFlingBehavior(listState)

    // Auto scroll coroutine
    LaunchedEffect(userInteracting) {
        if (userInteracting) return@LaunchedEffect

        delay(resumeDelay)

        while (true) {
            if (!listState.isScrollInProgress) {
                listState.scrollBy(autoScrollSpeed)

                val firstIndex = listState.firstVisibleItemIndex
                if (firstIndex >= items.size) {
                    listState.scrollToItem(firstIndex - items.size)
                }
            }
            delay(16L)
        }
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .hoverable(interactionSource),
        state = listState,
        flingBehavior = snapFlingBehavior,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(infiniteItems.size) { index ->
            HoverImage(
                width = itemWidth,
                height = 200.dp,
                model = infiniteItems[index]
            )
        }
    }
}

@Composable
fun AutoSlidingReviews(
    items: List<ReviewModel>,
    spacing: Dp = 16.dp,
    autoScrollSpeed: Float = 1.5f,
    resumeDelay: Long = 300L
) {
    val listState = rememberLazyListState()

    var anyCardHovered by remember { mutableStateOf(false) }
    val isDragging = listState.isScrollInProgress
    val userInteracting = isDragging || anyCardHovered

    var scrollDirection by remember { mutableStateOf(ScrollDirection.FORWARD) }

    val snapFlingBehavior = rememberSnapFlingBehavior(listState)

    LaunchedEffect(userInteracting, items) {
        if (items.isEmpty()) return@LaunchedEffect

        if (userInteracting) return@LaunchedEffect

        delay(resumeDelay)

        while (true) {
            val layoutInfo = listState.layoutInfo
            val viewportEnd = layoutInfo.viewportEndOffset

            val firstItem = layoutInfo.visibleItemsInfo.firstOrNull()
            val lastItem = layoutInfo.visibleItemsInfo.lastOrNull()

            val isAtStartFully =
                firstItem?.index == 0 && firstItem.offset >= 0

            val isAtEndFully =
                lastItem?.index == items.lastIndex &&
                        lastItem.offset + lastItem.size <= viewportEnd

            if (!userInteracting) {
                when {
                    isAtEndFully && scrollDirection == ScrollDirection.FORWARD ->
                        scrollDirection = ScrollDirection.BACKWARD

                    isAtStartFully && scrollDirection == ScrollDirection.BACKWARD ->
                        scrollDirection = ScrollDirection.FORWARD

                    else -> {
                        val delta =
                            if (scrollDirection == ScrollDirection.FORWARD)
                                autoScrollSpeed
                            else
                                -autoScrollSpeed

                        listState.scrollBy(delta)
                    }
                }
            }

            delay(16L)
        }
    }

    LazyRow(
        state = listState,
        flingBehavior = snapFlingBehavior,
        horizontalArrangement = Arrangement.spacedBy(spacing),
        contentPadding = PaddingValues(horizontal = 32.dp)
    ) {
        items(items.size) { index ->
            HoverImageReview(
                model = items[index],
                onHoverChanged = { hovered ->
                    anyCardHovered = hovered
                }
            )
        }
    }
}

private enum class ScrollDirection {
    FORWARD, BACKWARD
}



@Composable
fun HoverImageWork(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    index: Int,
    onClick: (Int) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    Box(
        modifier = modifier
            .aspectRatio(0.8f)
            .clip(RoundedCornerShape(16.dp))
            .hoverable(interactionSource)
            .clickable { onClick(index) }
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        if (isHovered) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color(0x80000000)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(Res.drawable.zoom2),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}

@Composable
fun HoverImageReview(
    model: ReviewModel,
    onHoverChanged: (Boolean) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    // 🔥 Bubble hover state to parent
    LaunchedEffect(isHovered) {
        onHoverChanged(isHovered)
    }

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.05f else 1f,
        label = "hover-scale"
    )

    Column(
        modifier = Modifier
            .width(250.dp)
            .then(
                if (isHovered)
                    Modifier
                        .wrapContentHeight()
                        .heightIn(min = 270.dp)
                else
                    Modifier.height(270.dp)
            )
            .scale(scale)
            .shadow(
                elevation = if (isHovered) 16.dp else 4.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))

            // 🔥 KEY FIX: allow drag to pass to LazyRow
            .pointerInput(Unit) {}

            .hoverable(interactionSource)
            .background(Color.White)
    ) {

        /* ---------- HEADER ---------- */
        Box(
            Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 22.dp, end = 20.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(model.clientImage),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )

                Column(Modifier.padding(start = 10.dp, top = 2.dp)) {
                    AppText(
                        text = model.clientName,
                        weight = AppFontWeight.SemiBold,
                        fontSize = 14.sp,
                        fontColor = Color.Black
                    )
                    AppText(
                        text = model.date,
                        weight = AppFontWeight.Regular,
                        fontSize = 12.sp,
                        fontColor = Colors.TextSecondary
                    )
                }
            }

            Image(
                painter = painterResource(Res.drawable.google),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.TopEnd)
            )
        }

        /* ---------- RATING ---------- */
        Row(
            Modifier.padding(start = 20.dp, top = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(5) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    tint = Colors.Orange,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }

            Spacer(Modifier.width(8.dp))

            Image(
                painter = painterResource(Res.drawable.blue_tick),
                contentDescription = null,
                modifier = Modifier.size(23.dp)
            )
        }

        /* ---------- MESSAGE ---------- */
        AppText(
            text = model.message,
            weight = AppFontWeight.Regular,
            fontSize = 13.sp,
            maxLines = if (isHovered) Int.MAX_VALUE else 7,
            fontColor = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 10.dp,
                    bottom = 20.dp
                )
        )
    }
}

@Composable
fun HoverImage(
    width: Dp,
    height: Dp,
    model: CardModel
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()

    val scale by animateFloatAsState(
        targetValue = if (isHovered) 1.05f else 1f,
        label = "hover-scale"
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .width(width)
                .height(height)
                .scale(scale)
                .shadow(
                    elevation = if (isHovered) 16.dp else 4.dp,
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .hoverable(interactionSource)
        ) {
            Image(
                painter = painterResource(model.image),
                contentDescription = "Company Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(width)
                    .height(height)
            )
        }

        Spacer(Modifier.height(10.dp))

        AppText(
            text = model.title,
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            weight = AppFontWeight.Regular, fontSize = 20.sp
        )

    }

}

data class ReviewModel(
    val message: String,
    val date: String = "",
    val clientName: String,
    val clientImage: DrawableResource
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun GifImage(modifier: Modifier = Modifier) {

//    AsyncImage(
//        model = Res.drawable.zoom,
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = modifier
//            .size(100.dp)
//    )
}

fun getReviewList(): List<ReviewModel> {
    return listOf(

        ReviewModel(
            message = "Got my perfect nail extensions done from Shalini! Absolutely loved her work. Super neat, long-lasting, and totally worth the price. Highly recommend her for anyone looking for quality nails at the best price.",
            clientName = "Shikha Tiwari",
            clientImage = Res.drawable.client_shikha_tiwari,
            date = "5 days ago"
        ),

        ReviewModel(
            message = "Shalini will take care of your nails more than you can! She is extremely polite, & her work is tremendous. You will enjoy her company as well as every penny is worth her talent. I have become a permanent customer. Highly recommended!",
            clientName = "Anushka",
            clientImage = Res.drawable.client_anushka_vashishtha,
            date = "2 weeks ago"
        ),

        ReviewModel(
            message = "Had an amazing experience!\n" +
                    "Got French nail art with extensions done and I’m absolutely in love with the results. The shape, finish, and precision were perfect, exactly what I had in mind. Shalini mam was professional, gentle, and made sure I was comfortable throughout. Super clean setup and great attention to detail. Highly recommend for elegant and beautiful nails.",
            clientName = "Smriti Rawat",
            clientImage = Res.drawable.client_smriti_rawat,
            date = "1 month 2025"
        ),

        ReviewModel(
            message = "The overall experience with Shalini Di was good. She is very honest to her work. Thankyou so much for the beautiful art on my nails.",
            clientName = "Geetanjali Palwal",
            clientImage = Res.drawable.client_geetanjali_palwal,
            date = "13th Feb 2025"
        ),

        ReviewModel(
            message = "I was impressed by how meticulous, knowledgeable and skilled Shalini is. She took my badly done nails extensions and turned them into awesome ones which I am obsessed with now! Thank you Shalini.",
            clientName = "Isha Moulick",
            clientImage = Res.drawable.client_isha_moulick,
            date = "31st Oct 2025"
        ),

        ReviewModel(
            message = "I had a great experince. Shalini did a very good job. She is professional and very good at her work. She did exact i wanted. She is very polite and patient with her work. Highly recommend her for nail extension. \uD83D\uDC4D\uD83C\uDFFB",
            clientName = "Sugandha Verma",
            clientImage = Res.drawable.client_sugandha_verma,
            date = "16th Oct 2024"
        ),

        ReviewModel(
            message = "I just wanted to express my gratitude and thanks to @\u2068~Shalini Sharma\u2069, who gave my nails a brand new look, even after they were damaged because of someone else! And what's more impressive is that she did it at 11 pm, just as she was about to sleep. Despite the short notice, she created an incredibly beautiful nail art design. I'm so thankful!",
            clientName = "Naincy Singh",
            clientImage = Res.drawable.client_naincy_singh,
            date = "12th Feb 2025"
        ),

        ReviewModel(
            message = "I am vry happy with the nail extension, i have tried for the first time & it gave m such a nice experience. She did good job without any harm .she is vry friendly also..",
            clientName = "Gunjan Ankit Jain",
            clientImage = Res.drawable.client_gunjan_ankit_jain,
            date = "16th Oct 2024"
        ),

        ReviewModel(
            message = "I did the nail extensions from her and she did it very well without any harm and apart from her work, her nature is very nice and calm",
            clientName = "Divyanshi Bansal",
            clientImage = Res.drawable.client_divyanshi_bansal,
            date = "24th Nov 2024"
        ),

        ReviewModel(
            message = "Beautiful designs , near n clean work , amazing services and you get the same nails which you show in the picture",
            clientName = "Divya Bhatia",
            clientImage = Res.drawable.client_divya_bhatia,
            date = "7th Mar 2025"
        ),


        )
}

fun getList(): List<CardModel> {
    return listOf(
        CardModel("Acrylic Nails", Res.drawable.work_2),
        CardModel("Acrylic Nails", Res.drawable.work_2),
        CardModel("Acrylic Nails", Res.drawable.work_2),
        CardModel("Acrylic Nails", Res.drawable.work_2),
        CardModel("Acrylic Nails", Res.drawable.work_2),
        CardModel("Acrylic Nails", Res.drawable.work_2),
        CardModel("Acrylic Nails", Res.drawable.work_2),
        CardModel("Acrylic Nails", Res.drawable.work_2),
    )
}

fun workImages(): List<DrawableResource> {
    return listOf(
        Res.drawable._8,
        Res.drawable._10,
        Res.drawable._13,
        Res.drawable._1,
        Res.drawable._2,
        Res.drawable._3,
        Res.drawable._4,
        Res.drawable._5,
        Res.drawable._6,
        Res.drawable._7,
        Res.drawable._9,
        Res.drawable._11,
        Res.drawable._12,
        Res.drawable._14,
        Res.drawable._15,
        Res.drawable._16,
        Res.drawable._17,
        Res.drawable._18,
        Res.drawable._19,
        Res.drawable._20,
        Res.drawable._21,
        Res.drawable._22,

        Res.drawable.lashes_1,
        Res.drawable.lashes_2,
        Res.drawable.lashes_3,
        Res.drawable.lashes_4,
//        Res.drawable.lashes_5,
//        Res.drawable.lashes_6,
//        Res.drawable.lashes_7,
//        Res.drawable.lashes_8,
    )
}

