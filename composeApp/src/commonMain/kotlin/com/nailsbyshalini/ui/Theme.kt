import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.*
import org.jetbrains.compose.resources.Font

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import nishalnailsandmakeover.composeapp.generated.resources.Res
import nishalnailsandmakeover.composeapp.generated.resources.*
object Colors {
    val Primary = Color(0xFFFE6A6C)
    val Orange = Color(0xFFECBE43)
    val Background = Color(0xFFFFF3F3)
    val TextPrimary = Color(0xFF424242)
    val TextSecondary = Color(0xFF7A7A7A)
}

@Composable
fun PoppinsFontFamily(): FontFamily =
    FontFamily(
        Font(Res.font.font_light, FontWeight.Light),
        Font(Res.font.font_regular, FontWeight.Normal),
        Font(Res.font.font_medium, FontWeight.Medium),
        Font(Res.font.font_semibold, FontWeight.SemiBold),
        Font(Res.font.font_bold, FontWeight.Bold)
    )

@Composable
fun DecorativeFontFamily(): FontFamily =
    FontFamily(
        Font(Res.font.decorative, FontWeight.Normal),
        Font(Res.font.decorative, FontWeight.Medium),
        Font(Res.font.decorative, FontWeight.SemiBold),
        Font(Res.font.decorative, FontWeight.Bold)
    )

enum class AppFontWeight {
    Light,
    Regular,
    Medium,
    SemiBold,
    Bold,
    Decorative,
}


enum class Sections {
    Home,
    Services,
    Gallery,
    About,
    Reviews,
    Contact,
}

