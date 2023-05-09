# Page Rank implementation using Graph

> Please find Java Doc here: target/site/apidocs/index.html
>
> Please find UML diagram here:

Page Rank is a well-known algorithm that is used by search engines to rank websites based on their relevance to a given
search query. It was first introduced by Google founders, Larry Page and Sergey Brin, as a way of measuring the
importance of web pages based on the number and quality of links that point to them.

Our project is an implementation of the Page Rank algorithm using graphs. In graph theory, a graph is a collection of
vertices (also called nodes) and edges that connect these vertices. Each vertex represents a web page, and each edge
represents a hyperlink from one page to another. We have implemented the graph using two data structures: Adjacency List
and Matrix.

To calculate the Page Rank score for each page, we used the iterative algorithm that was originally proposed by Page and
Brin. The algorithm works by assigning an initial Page Rank value to each page and then iteratively updating the Page
Rank values based on the incoming links from other pages. The algorithm stops when the Page Rank values converge to a
stable solution.

We have performed experiments to evaluate the performance of our implementation for different sets of data, convergence,
and CRUD operations. We used various datasets of web pages to test our implementation and measure the time taken to
calculate the Page Rank scores. We also tested the algorithm's ability to handle large graphs and its performance when
the graph is modified by adding or removing edges or vertices. We have tested the algorithm's ability to handle
convergence and found that it converges to a stable solution within a reasonable number of iterations.

### Contributors:

Vivek Murarka (22200673)

Nikhitha Grace Josh (22200726)

Purvish Shah (22200112)

Ravi Raj Pedada (22200547)

Meghana Kamsetty Ravikumar (22200568)