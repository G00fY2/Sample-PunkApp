package com.g00fy2.punkapp.model.transformer

import com.g00fy2.punkapp.model.entities.domain.Beer
import com.g00fy2.punkapp.model.entities.web.BeerWebEntity

interface BeerTransformer {

    fun toModel(entity: BeerWebEntity): Beer
}