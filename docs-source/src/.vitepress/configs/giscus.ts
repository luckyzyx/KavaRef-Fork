import type giscusTalk from 'vitepress-plugin-comment-with-giscus';

type GiscusOptions = Parameters<typeof giscusTalk>[0];

/** Lists source pages that must not mount the Giscus comment section. */
export const giscusExcludedPages = [
    'en/about/about.md',
    'zh-cn/about/about.md'
];

/** Defines the GitHub Discussions repository, category, and localized Giscus behavior. */
export const giscusOptions = {
    repo: 'HighCapable/KavaRef',
    repoId: 'R_kgDOOm7xeQ',
    category: 'General',
    categoryId: 'DIC_kwDOOm7xec4DB_aj',
    inputPosition: 'bottom',
    locales: {
        'en-US': 'en',
        'zh-CN': 'zh-CN'
    },
    homePageShowComment: false
} satisfies GiscusOptions;