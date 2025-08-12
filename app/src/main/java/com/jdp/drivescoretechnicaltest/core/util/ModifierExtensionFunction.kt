package com.jdp.drivescoretechnicaltest.core.util

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics

fun Modifier.invisibleToUser(mergeDescendants: Boolean = false): Modifier = this
    .semantics(mergeDescendants = mergeDescendants) {
        invisibleToUser()
    }