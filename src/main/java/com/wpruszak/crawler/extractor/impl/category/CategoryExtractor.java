package com.wpruszak.crawler.extractor.impl.category;

import com.wpruszak.crawler.extractor.AbstractExtractor;
import com.wpruszak.crawler.model.primary.entity.Category;
import com.wpruszak.crawler.model.primary.entity.CategoryGroup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * {@author Wojciech Pruszak} <info@wpruszak.com> on 29.03.17.
 */
@Service
public final class CategoryExtractor extends AbstractExtractor<CategoryGroup> {

    private static final Logger logger = LoggerFactory.getLogger(CategoryExtractor.class);

    private static final String SELECTOR_MAIN = ".popover-grouping";
    private static final String SELECTOR_CATEGORY_GROUP_TITLE = ".popover-category-name";
    private static final String SELECTOR_CATEGORY_ITEMS = ".nav_cat_links > li > a";

    private static final String REGEX_NODE_ID = "(?:(?:\\?|&)node=)(?<node>\\d+)(?:&|$)";

    @Override
    public List<CategoryGroup> extract(final String body) {
        this.toExtract = this.retrieveExtractableElements(body);
        return this.toExtract.stream().map(this::extractSingleElement).collect(Collectors.toList());
    }

    @Override
    protected Elements retrieveExtractableElements(final String body) {
        return Jsoup.parse(body).select(CategoryExtractor.SELECTOR_MAIN);
    }

    @Override
    protected CategoryGroup extractSingleElement(final Element rawCategoryGroup) {

        final CategoryGroup categoryGroup = new CategoryGroup();
        categoryGroup.setName(this.extractCategoryGroupName(rawCategoryGroup));
        categoryGroup.setCategories(this.extractCategories(rawCategoryGroup));

        return categoryGroup;
    }

    private String extractCategoryGroupName(final Element rawCategoryGroup) {
        return rawCategoryGroup.select(CategoryExtractor.SELECTOR_CATEGORY_GROUP_TITLE).text();
    }

    private Set<Category> extractCategories(final Element element) {

        return element
            .select(CategoryExtractor.SELECTOR_CATEGORY_ITEMS)
            .stream()
            .map(this::extractSingleCategory)
            .collect(Collectors.toSet());
    }

    private Category extractSingleCategory(final Element rawCategory) {

        final Category category = new Category();
        category.setName(rawCategory.text());
        category.setNodeId(this.extractNodeId(rawCategory.attr("href")));

        return category;
    }

    private String extractNodeId(final String rawNodeId) {

        final Matcher matcher = Pattern.compile(CategoryExtractor.REGEX_NODE_ID)
            .matcher(rawNodeId);
        matcher.find();

        try {
            return matcher.group("node");
        } catch (IllegalStateException exception) {
            logger.error(String.format(
                "%s: %s",
                "Node id not found: ",
                Arrays.toString(exception.getStackTrace())
            ));
        } catch (Exception exception) {
            logger.error(Arrays.toString(exception.getStackTrace()));
        }

        return "";
    }
}
