package com.g00fy2.punkapp.model.transformer

import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.model.entities.web.BeerWebEntity
import javax.inject.Inject

class BeerTransformerImpl @Inject constructor() : BeerTransformer {

    override fun toModel(entity: BeerWebEntity): Beer {
        return with(entity) {
            Beer(
                    id = id,
                    name = name,
                    tagline = tagline,
                    first_brewed = first_brewed,
                    description = description,
                    image_url = image_url,
            )
        }
    }
}