package app.luma.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import app.luma.R
import app.luma.data.Prefs
import app.luma.helper.performAppTapHapticFeedback
import app.luma.style.SettingsTheme
import app.luma.ui.compose.SettingsComposable.MessageText
import app.luma.ui.compose.SettingsComposable.SettingsHeader

class StrictModeEnableFragment : Fragment() {
    private lateinit var prefs: Prefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prefs = Prefs.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = composeView(onSwipeBack = ::goBack) { StrictModeEnableScreen() }

    @Composable
    private fun StrictModeEnableScreen() {
        Column(modifier = Modifier.fillMaxSize()) {
            SettingsHeader(
                title = stringResource(R.string.strict_mode_title),
                onBack = ::goBack,
            )
            MessageText(
                text = stringResource(R.string.strict_mode_enable_description),
                modifier = Modifier.padding(start = 37.dp, end = 37.dp, top = 16.dp),
            )
            val context = LocalContext.current
            Box(
                modifier =
                    Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .padding(bottom = 14.dp, start = 37.dp, end = 37.dp),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = stringResource(R.string.strict_mode_cancel).uppercase(),
                        style = SettingsTheme.typography.pageButton,
                        fontSize = 40.sp,
                        modifier =
                            Modifier.noRippleClickable {
                                performAppTapHapticFeedback(context)
                                goBack()
                            },
                    )
                    Text(
                        text = stringResource(R.string.strict_mode_proceed).uppercase(),
                        style = SettingsTheme.typography.pageButton,
                        fontSize = 40.sp,
                        modifier =
                            Modifier.noRippleClickable {
                                performAppTapHapticFeedback(context)
                                prefs.strictModeEnabled = true
                                findNavController().popBackStack(R.id.mainFragment, false)
                            },
                    )
                }
            }
        }
    }
}
