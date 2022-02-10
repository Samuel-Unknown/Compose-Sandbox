package com.example.compose.sandbox

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun switcher(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    isEnabled: Boolean = true
): Boolean {

    val (value, setValue) = remember { mutableStateOf(checked) }

    Switch(
        modifier = modifier,
        checked = value, onCheckedChange = setValue,
        enabled = isEnabled
    )

    return true
}