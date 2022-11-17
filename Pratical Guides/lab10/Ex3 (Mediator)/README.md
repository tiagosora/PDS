1) Quando temos um problema técnico no nosso computador podemos recorrer ao serviço de apoio ao cliente. Neste espaço um funcionário pede-nos para descever o nosso problema e de seguida somos reencaminhados para outro do departamento específico para a nossa questão. Para evitar esta troca entre funcionários é útil recorrer ao padrão Mediator, tornando o primeiro funcionário o único ponto de contacto com cliente, já que esse passa a ser responsável por comunicar com os diferentes departamentos e de seguida reencaminhar a solução para o cliente.

2) Assim, criámos uma classe CustomerCare que implementa a interface CustomerCareInterface que contém os métodos de comunicação entre o cliente e os departamentos. Além disso, criámos a classe abstrata Department a qual é extendida para o ScreenDepartment e SoundDepartment. Também implementámos uma classe Customer que comunica com o CustomerCare.

3. Para criar este problema recorremos:
   1. aos slides fornecidos;
   2. ao site https://refactoring.guru/design-patterns/mediator;
   3. e ao exemplo do site https://programmingline.com/software-design-patterns/mediator-design-pattern, no qual nos baseámos parao nosso exercício.