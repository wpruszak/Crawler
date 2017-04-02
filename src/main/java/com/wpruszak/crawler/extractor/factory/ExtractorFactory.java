package com.wpruszak.crawler.extractor.factory;

import com.wpruszak.crawler.extractor.Extractor;
import com.wpruszak.crawler.util.FactoryInterface;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 30.03.17.
 */
public interface ExtractorFactory extends FactoryInterface<Extractor> {

    Extractor create();
}
