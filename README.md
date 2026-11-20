# docs-sync demo: code repo

A small, made-up "Sales Insights" product used to demo the docs sync workflow.
It has the same kinds of folders as the real source repos, in one repo:

| Folder | Plays the part of | What docs_sync reads |
| --- | --- | --- |
| `extractor/` | the Bronze extractor | `config/extracts.json`, `config/sql_config.yml`, `sql/` |
| `dbt_project/` | the dbt Silver project | `dbt_project.yml`, `models/` |
| `snowflake/migrations/` | the Snowflake schemachange repo | `V*__*.sql`, `R__*.sql` |
| `tenant-api/` | the Tenant API | `@Query(..., nativeQuery = true)` in `repositories/`, shared SQL in `constants/` |
| `experience-api/` | the Experience API | the service files under `src/api/sales` |

`.github/workflows/notify-docs.yml` tells the docs repo that something changed after
every push to `develop`. It sends only the repo name and the commit.

All data, names and tables here are invented for the demo.
