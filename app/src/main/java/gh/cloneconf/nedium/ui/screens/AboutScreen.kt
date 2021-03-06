package gh.cloneconf.nedium.ui.screens

import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Code
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import gh.cloneconf.nedium.BuildConfig
import gh.cloneconf.nedium.Const.REPO_LINK
import gh.cloneconf.nedium.R

@kotlin.OptIn(ExperimentalMaterialApi::class)
@Destination
@Composable
fun AboutScreen(navigator: DestinationsNavigator) {


    val ctx = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.about)) },
                navigationIcon = {
                    IconButton(onClick = { navigator.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
        }
    ) {


        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            AndroidView(factory = {
                ImageView(it).apply {
                    setImageResource(R.mipmap.ic_launcher)
                }
            })
            Text(stringResource(R.string.app_name))
            Text(BuildConfig.VERSION_NAME)

            OutlinedButton(
                onClick = {
                    ctx.startActivity(
                        Intent(Intent.ACTION_VIEW).setData(Uri.parse(REPO_LINK))
                    )
                }
            ) {

                Icon(Icons.Default.Code, null)
                Text(stringResource(R.string.source_code))

            }

        }


    }

}