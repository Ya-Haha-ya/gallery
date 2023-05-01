package xia.zhao.gallery.photo

sealed class PhotoUiModel

internal object PhotoUiLoading : PhotoUiModel()

internal object PhotoUiLoaded : PhotoUiModel()
