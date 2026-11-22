package com.nailsbyshalini

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
@org.jetbrains.compose.ui.tooling.preview.Preview
fun App() {

    val images = remember { workImages() }

    var selectedIndex by remember { mutableStateOf<Int?>(null) }

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Box {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize().background(Colors.Background),
        ) {
            item {
                TopBar { index ->                                               // 0
                    scope.launch {
                        when(index){
                            Sections.Home -> { listState.animateScrollToItem(0) }
                            Sections.Services -> { listState.animateScrollToItem(5) }
                            Sections.Gallery -> { listState.animateScrollToItem(9) }
                            Sections.About -> { listState.animateScrollToItem(7) }
                            Sections.Reviews -> { listState.animateScrollToItem(10) }
                            else -> { listState.animateScrollToItem(12) }
                        }

                    }
                }
            }

            item { Spacer(Modifier.height(30.dp)) }                             // 1

            item { HeroSection() }                                              // 2

            item { DividerWithImage() }                                         // 3

            item { ServicesSection() }                                          // 4

            item { GallerySection() }                                           // 5

            item { DividerWithImage() }                                         // 6

            item { AboutSection() }                                             // 7

            item { DividerWithImage() }                                         // 8

            item { SeeOurWork(onImageClicked = { selectedIndex = it }, images) }                                               // 9

            item { DividerWithImage() }                                         // 10

            item { ClientReviews() }                                            // 11

            item { DividerWithImage() }                                         // 12

            item { CallSection() }                                              // 13

            item { FooterSection() }                                            // 14

            item { Spacer(Modifier.height(10.dp)) }                             // 15

        }

        selectedIndex?.let {
            FullScreenOverlayCarousel(
                images = images,
                startIndex = it,
                onClose = {
                    selectedIndex = null
                }
            )
        }

    }

}

