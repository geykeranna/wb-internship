package ru.wb.ui.ui.component.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class PhoneNumberVisualTransformation(
    private val mask: String
): VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        var out = ""
        val listSeparation = mutableListOf<Separation>()

        text.forEachIndexed { index, inputNum ->
            out += inputNum
            val newIndex = index + listSeparation.size + 1
            if (newIndex != mask.length && mask[newIndex] != '0') {
                out += mask[newIndex]
                listSeparation.add(
                    Separation(
                        index = newIndex,
                        sign = mask[newIndex]
                    )
                )
            }
        }

        listSeparation.add(Separation(index = mask.length, sign = null))

        // Yes, hardcore, but I'll rewrite it later
        val offsetMapping = object: OffsetMapping {
            override fun originalToTransformed(offset: Int) =
                when{
                    offset <= listSeparation[0].index - 1 -> offset
                    offset <= listSeparation[1].index - 1 -> offset + 1
                    offset <= listSeparation[2].index - 1 -> offset + 2
                    offset <= listSeparation[3].index - 1 -> offset + 3
                    else -> mask.length
                }

            override fun transformedToOriginal(offset: Int) =
                when{
                    offset <= listSeparation[0].index -> offset
                    offset <= listSeparation[1].index -> offset - 1
                    offset <= listSeparation[2].index -> offset - 2
                    offset <= listSeparation[3].index -> offset - 3
                    else -> mask.length - listSeparation.size
                }

        }
        return TransformedText(
            text = AnnotatedString(text = out),
            offsetMapping = offsetMapping
        )
    }
}

private data class Separation (
    val index: Int,
    val sign: Char?
)