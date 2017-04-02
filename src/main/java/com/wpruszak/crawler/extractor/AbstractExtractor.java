package com.wpruszak.crawler.extractor;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 28.03.17.
 */
public abstract class AbstractExtractor<T> implements Extractor<T> {

    protected Elements toExtract;

    public abstract List<T> extract(final String body);

    protected abstract Elements retrieveExtractableElements(String body);

    protected abstract T extractSingleElement(Element element);
}
