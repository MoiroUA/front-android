package io.moiro.vision.screens.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen() {
    val systemUiController = rememberSystemUiController()
    val lviv = LatLng(49.842957, 24.031111)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(lviv, 15f)
    }
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(0xFFFFFFFF)
        )
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        uiSettings = MapUiSettings(zoomControlsEnabled = false)
    ) {
        Polygon(
            points = listOf(
                LatLng(49.8420443, 23.9677062),
                LatLng(49.8428746, 23.9788642),
                LatLng(49.8434835, 23.9816966),
                LatLng(49.8468597, 23.9905372),
                LatLng(49.8490735, 23.9960304),
                LatLng(49.855161, 23.98204),
                LatLng(49.855161, 23.9719978),
                LatLng(49.8530581, 23.9596382),
                LatLng(49.852062, 23.9528575),
                LatLng(49.8446458, 23.9528575),
                LatLng(49.8413801, 23.9613548),
                LatLng(49.8420443, 23.9677062)
            ),
            fillColor = Color.Red.copy(alpha = 0.3f),
            strokeColor = Color.Red
        )
        Polygon(
            points = listOf(
                LatLng(49.8205454, 23.9688754),
                LatLng(49.8213761, 23.9683604),
                LatLng(49.8227051, 23.9668154),
                LatLng(49.8221513, 23.9656996),
                LatLng(49.8201578, 23.9646697),
                LatLng(49.8198809, 23.9636397),
                LatLng(49.8190502, 23.9643263),
                LatLng(49.8172227, 23.9579749),
                LatLng(49.8166135, 23.9583182),
                LatLng(49.8157274, 23.959434),
                LatLng(49.8156167, 23.9619231),
                LatLng(49.8136783, 23.9638972),
                LatLng(49.8139552, 23.9650988),
                LatLng(49.8125706, 23.9671587),
                LatLng(49.8107428, 23.9692187),
                LatLng(49.8111305, 23.9699053),
                LatLng(49.8132906, 23.9736819),
                LatLng(49.8141767, 23.9752268),
                LatLng(49.8121829, 23.9808917),
                LatLng(49.8137336, 23.9814066),
                LatLng(49.8155059, 23.9821791),
                LatLng(49.8166689, 23.9823508),
                LatLng(49.8176104, 23.9821791),
                LatLng(49.8195486, 23.9803767),
                LatLng(49.8199917, 23.9833807),
                LatLng(49.8208223, 23.9832949),
                LatLng(49.8219298, 23.9810633),
                LatLng(49.8225943, 23.9787459),
                LatLng(49.8240894, 23.9768576),
                LatLng(49.8205454, 23.9688754)
            ),
            fillColor = Color.Red.copy(alpha = 0.3f),
            strokeColor = Color.Red
        )
        Polygon(
            points = listOf(
                LatLng(49.8385672, 23.9944529),
                LatLng(49.8389823, 23.9941525),
                LatLng(49.8392868, 23.992908),
                LatLng(49.8400064, 23.988316),
                LatLng(49.840726, 23.9862561),
                LatLng(49.840643, 23.9842391),
                LatLng(49.8385672, 23.9822649),
                LatLng(49.8371279, 23.9808917),
                LatLng(49.8364359, 23.9814496),
                LatLng(49.8349412, 23.9826083),
                LatLng(49.8355225, 23.9861273),
                LatLng(49.8361314, 23.9892601),
                LatLng(49.8367404, 23.992908),
                LatLng(49.8372109, 23.9960837),
                LatLng(49.8367681, 23.996427),
                LatLng(49.8362145, 23.9965987),
                LatLng(49.8359377, 23.9956545),
                LatLng(49.8355502, 23.9938521),
                LatLng(49.8355225, 23.9916634),
                LatLng(49.835301, 23.9906764),
                LatLng(49.834609, 23.9909338),
                LatLng(49.8334465, 23.9909338),
                LatLng(49.8316195, 23.9907622),
                LatLng(49.8299862, 23.9904189),
                LatLng(49.827993, 23.9899039),
                LatLng(49.8294326, 23.9931654),
                LatLng(49.8302077, 23.9950537),
                LatLng(49.8315364, 23.9980578),
                LatLng(49.8324776, 23.9999461),
                LatLng(49.8332527, 23.9991307),
                LatLng(49.8336956, 23.9987444),
                LatLng(49.8348028, 23.9982295),
                LatLng(49.8358546, 23.9976286),
                LatLng(49.8362698, 23.9996886),
                LatLng(49.8366297, 24.0015769),
                LatLng(49.8368511, 24.0015769),
                LatLng(49.8371556, 24.0012335),
                LatLng(49.8384564, 23.9975428),
                LatLng(49.8390654, 23.9958262),
                LatLng(49.8385672, 23.9944529)
            ),
            fillColor = Color.Red.copy(alpha = 0.3f),
            strokeColor = Color.Red
        )
        Polygon(
            points = listOf(
                LatLng(49.8021015, 24.017915),
                LatLng(49.8007165, 24.0178292),
                LatLng(49.7988329, 24.0171425),
                LatLng(49.7968938, 24.0170567),
                LatLng(49.796506, 24.021949),
                LatLng(49.796506, 24.0276997),
                LatLng(49.796506, 24.0332787),
                LatLng(49.7976141, 24.0361111),
                LatLng(49.7978357, 24.0390293),
                LatLng(49.7967276, 24.0392868),
                LatLng(49.7943452, 24.0408318),
                LatLng(49.7947885, 24.0457241),
                LatLng(49.7944006, 24.0488999),
                LatLng(49.7949547, 24.0513031),
                LatLng(49.7961736, 24.0528481),
                LatLng(49.7966722, 24.0522473),
                LatLng(49.7975033, 24.0531056),
                LatLng(49.7991099, 24.054908),
                LatLng(49.7999963, 24.0551655),
                LatLng(49.7999409, 24.0567963),
                LatLng(49.7991653, 24.059972),
                LatLng(49.7980573, 24.0628044),
                LatLng(49.7986113, 24.0634911),
                LatLng(49.8012705, 24.0652935),
                LatLng(49.8029325, 24.0640919),
                LatLng(49.8043174, 24.0631478),
                LatLng(49.8064777, 24.061002),
                LatLng(49.8067547, 24.0588562),
                LatLng(49.8071978, 24.0543072),
                LatLng(49.8076963, 24.050359),
                LatLng(49.8076963, 24.0472691),
                LatLng(49.8057576, 24.0469258),
                LatLng(49.8044835, 24.0465824),
                LatLng(49.8032648, 24.0464966),
                LatLng(49.8028217, 24.0482132),
                LatLng(49.8019353, 24.0470116),
                LatLng(49.8008273, 24.0430634),
                LatLng(49.7998301, 24.0370552),
                LatLng(49.8003841, 24.0293305),
                LatLng(49.8021015, 24.017915)
            ),
            fillColor = Color.Red.copy(alpha = 0.3f),
            strokeColor = Color.Red
        )
        Polygon(
            points = listOf(
                LatLng(49.8266413, 24.0106719),
                LatLng(49.8257276, 24.0113157),
                LatLng(49.8270012, 24.013204),
                LatLng(49.8276656, 24.0142339),
                LatLng(49.8281639, 24.0138906),
                LatLng(49.8292159, 24.0152639),
                LatLng(49.8297418, 24.0152639),
                LatLng(49.8296588, 24.0168518),
                LatLng(49.8301571, 24.0169805),
                LatLng(49.8303786, 24.0171951),
                LatLng(49.830517, 24.0164655),
                LatLng(49.8309322, 24.0161222),
                LatLng(49.8305446, 24.0151351),
                LatLng(49.8295204, 24.0137189),
                LatLng(49.8286345, 24.012689),
                LatLng(49.8276933, 24.0118307),
                LatLng(49.8266413, 24.0106719)
            ),
            fillColor = Color.Red.copy(alpha = 0.3f),
            strokeColor = Color.Red
        )
    }
}