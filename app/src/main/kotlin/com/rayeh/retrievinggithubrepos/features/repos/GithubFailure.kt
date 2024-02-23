package com.rayeh.retrievinggithubrepos.features.repos

import com.rayeh.retrievinggithubrepos.core.exception.Failure.FeatureFailure

class GithubFailure {
    class ListNotAvailable: FeatureFailure()
}