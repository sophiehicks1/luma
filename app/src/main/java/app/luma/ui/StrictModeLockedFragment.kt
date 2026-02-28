package app.luma.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import app.luma.R
import app.luma.ui.compose.SettingsComposable.MessageText
import app.luma.ui.compose.SettingsComposable.SettingsHeader

class StrictModeLockedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = composeView(onSwipeBack = ::goBack) { StrictModeLockedScreen() }

    @Composable
    private fun StrictModeLockedScreen() {
        Column(modifier = Modifier.fillMaxSize()) {
            SettingsHeader(
                title = stringResource(R.string.strict_mode_title),
                onBack = ::goBack,
            )
            MessageText(
                text = stringResource(R.string.strict_mode_locked_description),
                modifier = Modifier.padding(start = 37.dp, end = 37.dp, top = 16.dp),
            )
        }
    }
}
