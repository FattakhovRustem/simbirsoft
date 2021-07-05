# simbirsoft

Spring Boot веб приложение.

СУБД PostgreSQL:
DATABASE simbirsoft
CREATE TABLE public.page
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name text,
    link text,
    CONSTRAINT page_pkey PRIMARY KEY (id)
)
CREATE TABLE public.statistics
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    page_id integer NOT NULL,
    name text,
    count integer,
    CONSTRAINT statistics_pkey PRIMARY KEY (id, page_id)
)

Приложение принимает полноценный адрес html-страницы, например, https://www.simbirsoft.com/
Возможные запросы:
localhost:8080/page/saveAndParse - сохраняет html страницу в файл, парсит текст страницы, сохраняет данные о странице и его статистику в базу
Сохранение и парсинг происходит в классе Html.
Отправка json в виде:
{
    "name":"симбирсофт",
    "link":"https://www.simbirsoft.com/"
}

localhost:8080/page/findAll - возвращает информацию о всех страницах из базы в виде json
localhost:8080/page/{pageId}/statistics - возвращает статистику в виде json по указаной id страницы - {pageId}
